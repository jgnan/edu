package org.shenit.tutorial.android.dataproc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.android.R;
import org.shenit.tutorial.android.entities.Article;

public class SugarOrmExampleActivity extends AppCompatActivity {
    private EditText idText;
    private EditText titleText;
    private EditText authorText;
    private EditText contentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);
        idText = (EditText) findViewById(R.id.article_id);
        titleText = (EditText) findViewById(R.id.title);
        authorText = (EditText) findViewById(R.id.author);
        contentText = (EditText) findViewById(R.id.content);

        Button saveBtn = (Button) findViewById(R.id.save);
        Button loadBtn = (Button) findViewById(R.id.load);
        Button deleteBtn = (Button) findViewById(R.id.delete);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSave();
            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLoad();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDelete();
            }
        });
    }

    private void doDelete() {
        String idStr = idText.getText().toString();
        if(TextUtils.isEmpty(idStr)){
            Toast.makeText(this,"Could not delete record without id!!", Toast.LENGTH_SHORT).show();
            return;
        }
        Article art = Article.findById(Article.class, Long.parseLong(idStr));
        art.delete();
        setData(null);
        Toast.makeText(this,"Delete record["+idStr+"] success!",Toast.LENGTH_SHORT).show();
    }

    private void doLoad() {
        String idStr = idText.getText().toString();
        if(TextUtils.isEmpty(idStr)) {
            Toast.makeText(this,"No id to load!",Toast.LENGTH_SHORT).show();
            return;
        }
        Article art = Article.findById(Article.class, Long.parseLong(idStr));
        setData(art);

        Toast.makeText(this,"Loaded from database finished",Toast.LENGTH_SHORT).show();
    }

    private void setData(Article art) {
        if(art != null){
            idText.setText(String.valueOf(art.getId()));
            titleText.setText(art.title);
            authorText.setText(art.author);
            contentText.setText(art.content);
        }else{
            idText.setText(null);
            titleText.setText(null);
            authorText.setText(null);
            contentText.setText(null);
        }

    }

    private void doSave() {
        Article art = new Article();
        String idStr = idText.getText().toString();
        if(!TextUtils.isEmpty(idStr)  && TextUtils.isDigitsOnly(idStr)) art.setId(Long.parseLong(idStr));
        art.title = titleText.getText().toString();
        art.content = contentText.getText().toString();
        art.author = authorText.getText().toString();
        art.save();
        idText.setText(String.valueOf(art.getId()));
        Toast.makeText(this,"Save to database success!",Toast.LENGTH_SHORT).show();
    }
}
