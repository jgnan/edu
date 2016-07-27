package org.shenit.tutorial.android.dataproc;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.TutorialUtils;
import org.shenit.tutorial.android.entities.Article;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 外部存储示例代码.
 */
public class ExternalStorageExampleActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText contentText;
    private EditText resourceText;
    private Spinner typeSpinner;
    private String fileName = "article";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_example);
        titleText = (EditText) findViewById(R.id.title);
        contentText = (EditText) findViewById(R.id.content);
        resourceText = (EditText) findViewById(R.id.resource);
        resourceText.setText("http://www.walltor.com/images/wallpaper/wii-crazy-rabbit-60386.jpg");     //default stream
        typeSpinner = (Spinner) findViewById(R.id.type);
        typeSpinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                new String[]{Environment.DIRECTORY_MOVIES,Environment.DIRECTORY_MUSIC,
                        Environment.DIRECTORY_DOWNLOADS,Environment.DIRECTORY_PICTURES}));

        Button saveBtn = (Button) findViewById(R.id.save);
        Button loadBtn = (Button) findViewById(R.id.load);
        Button saveToPublicBtn = (Button) findViewById(R.id.save_to_public);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromFile();
            }
        });
        saveToPublicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToPublic();
            }
        });
    }

    private void saveToPublic() {
        String resource = resourceText.getText().toString();
        String dirType = (String)typeSpinner.getSelectedItem();

        new DownloadFileAsyncTask().execute(resource,dirType);

    }

    /*
     * 加载外部文件数据
     */
    private void loadFromFile() {
        if(!TutorialUtils.isExternalStorageReadable()){
            Toast.makeText(this, "No external storage avaialble", Toast.LENGTH_SHORT).show();
            return;
        }
        //读取外部的CONTEXT文件夹
        File file = new File(getExternalFilesDir(null),fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            Article art = TutorialUtils.gson().fromJson(line,Article.class);
            titleText.setText(art.title);
            contentText.setText(art.content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(reader);
        }
        Toast.makeText(this,"Load data from file -> "+file.toString(),Toast.LENGTH_SHORT).show();
    }

    /*
     * 保存输入数据到外部文件
     */
    private void saveToFile() {
        if(!TutorialUtils.isExternalStorageWritable()){
            Toast.makeText(this, "No external storage avaialble", Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(getExternalFilesDir(null),fileName);
        Article art = new Article(titleText.getEditableText().toString(), contentText.getEditableText().toString());
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.append(TutorialUtils.gson().toJson(art));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(writer);

        }
        Toast.makeText(this,"Save data to file -> "+file.toString(),Toast.LENGTH_SHORT).show();
    }

    class DownloadFileAsyncTask extends AsyncTask<String,Void,File> {

        @Override
        protected File doInBackground(String... params) {
            String urlStr = params[0];
            File dir = Environment.getExternalStoragePublicDirectory(params[1]);
            FileOutputStream fos = null;
            URL url = null;
            URLConnection conn = null;
            File file = null;
            try {
                url = new URL(urlStr);
                //get the last part as file name in url path
                String fileName = url.getPath();
                fileName = fileName.substring(fileName.lastIndexOf("/")+1);

                file = new File(dir, fileName);
                fos = new FileOutputStream(file);
                conn = url.openConnection();
                InputStream is = conn.getInputStream();
                byte[] buff = new byte[10240];
                int read;
                while ((read = is.read(buff)) > 0) {
                    fos.write(buff, 0, read);
                }
                fos.flush();
            } catch (IOException e) {
                Log.e(TutorialUtils.class.getSimpleName(), "Error saving resources[" + urlStr + "] to file[" + file + "]", e);
            } finally {
                IOUtils.close(conn);
                IOUtils.closeQuietly(fos);
            }
            return file;
        }

        @Override
        protected void onPostExecute(File file) {
            Toast.makeText(ExternalStorageExampleActivity.this, "Save resource to file ["+file+"]", Toast.LENGTH_LONG).show();
        }
    }
}
