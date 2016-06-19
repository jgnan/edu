package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.Utils;
import org.shenit.tutorial.android.entities.Article;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 内部存储示例2
 */
public class InternalStorageExampleActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText contentText;
    //存储文件名
    private String fileName = "article";
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_example);
        titleText = (EditText) findViewById(R.id.title);
        contentText = (EditText) findViewById(R.id.content);
        Button saveBtn = (Button) findViewById(R.id.save);
        Button loadBtn = (Button) findViewById(R.id.load);
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

//        //获取文件的java.io.File实例
//        file = new File(getFilesDir(),fileName);
//        //假如文件不存在我们需要自己做初始化处理
//        if(!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /*
     * 加载数据示例
     */
    private void loadFromFile() {
        BufferedReader reader = null;
        try {
            //创建一个Reader实例便于进行IO操作
//            reader = new BufferedReader(new FileReader(file));
            //直接获取制定文件的InputStream流
            reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            String line = reader.readLine();
            //利用GSON把JSON格式数据反序列化为Article数据格式
            Article art = Utils.gson().fromJson(line,Article.class);
            //使用数据
            titleText.setText(art.title);
            contentText.setText(art.content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //使用完的IO资源必须进行关闭
            IOUtils.closeQuietly(reader);
        }
//        Toast.makeText(this,"Load data from file -> "+file.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Load data from file -> "+fileName,Toast.LENGTH_SHORT).show();
    }

    /*
     * 保存数据示例
     */
    private void saveToFile() {
        Article art = new Article(titleText.getEditableText().toString(), contentText.getEditableText().toString());
//        FileWriter writer = null;
        OutputStreamWriter writer = null;
        try {
            //创建一个Writer实例便于往文件写入数据
//            writer = new FileWriter(file);
            //直接获取文件的Output
            writer = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            //利用GSON库把Article数据JSON化并且保存到目标文件中
            writer.append(Utils.gson().toJson(art));
            //从缓存写入到文件
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //使用完的IO资源必须进行关闭
            IOUtils.closeQuietly(writer);
        }
//        Toast.makeText(this,"Save data to file -> "+file.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Save data to file -> "+fileName,Toast.LENGTH_SHORT).show();
    }
}
