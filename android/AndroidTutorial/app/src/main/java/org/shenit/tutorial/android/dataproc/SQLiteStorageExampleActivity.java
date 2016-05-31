package org.shenit.tutorial.android.dataproc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shenit.tutorial.R;
import org.shenit.tutorial.android.entities.SugarArticle;

public class SQLiteStorageExampleActivity extends AppCompatActivity {
    private EditText idText;
    private EditText titleText;
    private EditText authorText;
    private EditText contentText;
    private MySQLiteOpenHelper sqlHelper;
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
        sqlHelper = new MySQLiteOpenHelper(this);
    }

    private void doDelete() {
        String idStr = idText.getText().toString();
        if(TextUtils.isEmpty(idStr)){
            Toast.makeText(this,"Could not delete record without id!!", Toast.LENGTH_SHORT).show();
            return;
        }
//        SQLiteDatabase db = sqlHelper.getWritableDatabase();
//        db.delete("articles","id = ?",new String[]{idStr});
        SugarArticle art = SugarArticle.findById(SugarArticle.class,Long.parseLong(idStr));
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
//        Cursor cursor = sqlHelper.getReadableDatabase().query("articles",
//                new String[]{"id","title","author","content"},    //columns
//                "id = ?",new String[]{idStr},
//                null,null,null,null);
//        if(cursor.moveToNext()){
//            idText.setText(cursor.getString(cursor.getColumnIndex("id")));
//            titleText.setText(cursor.getString(cursor.getColumnIndex("title")));
//            authorText.setText(cursor.getString(cursor.getColumnIndex("author")));
//            contentText.setText(cursor.getString(cursor.getColumnIndex("content")));
//        }else{
//            titleText.setText(null);
//            authorText.setText(null);
//            contentText.setText(null);
//        }
        SugarArticle art = SugarArticle.findById(SugarArticle.class, Long.parseLong(idStr));
        setData(art);

        Toast.makeText(this,"Loaded from database finished",Toast.LENGTH_SHORT).show();
    }

    private void setData(SugarArticle art) {
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
//        SQLiteDatabase db = sqlHelper.getWritableDatabase();
//        String idStr = idText.getText().toString();
//        Integer id = null;
//        if(!TextUtils.isEmpty(idStr) && TextUtils.isDigitsOnly(idStr)) id = Integer.parseInt(idStr);
//        ContentValues record = new ContentValues();
//        record.put("title",titleText.getText().toString());
//        record.put("author", authorText.getText().toString());
//        record.put("content", contentText.getText().toString());
//        if(id == null){
//            //execute an insert sql
//            long newId = db.insert("articles", null, record);
//            idText.setText(String.valueOf(newId));
//        } else {
//            db.update("articles", record, " id = ? ", new String[]{id.toString()});
//        }
        SugarArticle art = new SugarArticle();
        art.title = titleText.getText().toString();
        art.content = contentText.getText().toString();
        art.author = authorText.getText().toString();
        art.save();
        idText.setText(String.valueOf(art.getId()));
        Toast.makeText(this,"Save to database success!",Toast.LENGTH_SHORT).show();
    }
}
