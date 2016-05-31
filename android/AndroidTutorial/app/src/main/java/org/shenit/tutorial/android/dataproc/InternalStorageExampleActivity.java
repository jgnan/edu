package org.shenit.tutorial.android.dataproc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.R;
import org.shenit.tutorial.android.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Internal File storage example.
 */
public class InternalStorageExampleActivity extends AppCompatActivity {
    private EditText titleText;
    private EditText contentText;
    private String fileName = "article";
//    private File file;
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


//        file = new File(getFilesDir(),"article");
//        if(!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /*
     * Load data from file
     */
    private void loadFromFile() {
        BufferedReader reader = null;
        try {
//            reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            String line = reader.readLine();
            Article art = Utils.gson().fromJson(line,Article.class);
            titleText.setText(art.title);
            contentText.setText(art.content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(reader != null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        Toast.makeText(this,"Load data from file -> "+file.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Load data from file -> "+fileName,Toast.LENGTH_SHORT).show();
    }

    /*
     * Save data to file
     */
    private void saveToFile() {
        Article art = new Article(titleText.getEditableText().toString(), contentText.getEditableText().toString());
//        FileWriter writer = null;
        OutputStreamWriter writer = null;
        try {
//            writer = new FileWriter(file);
            writer = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            writer.append(Utils.gson().toJson(art));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(writer != null) try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        Toast.makeText(this,"Save data to file -> "+file.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Save data to file -> "+fileName,Toast.LENGTH_SHORT).show();
    }
}
