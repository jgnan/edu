package org.shenit.helloworld.dataproc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.shenit.helloworld.R;

import java.util.HashMap;
import java.util.Map;

public class JsonProcessExample extends AppCompatActivity {
    EditText titleText;
    EditText contentText;
    TextView resultText;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_process_example);
        titleText = (EditText) findViewById(R.id.title);
        contentText = (EditText) findViewById(R.id.content);
        resultText = (TextView) findViewById(R.id.result);

        String json = "{\"content\":\"This is a preload json contentText\",\"title\":\"Preload Title\"}";
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            titleText.setText(jsonObject.getString("titleText"));
//            contentText.setText(jsonObject.getString("contentText"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Map<String,Object> data = gson.fromJson(json,new TypeToken<Map<String,Object>>(){}.getType());
//        titleText.setText((String) data.get("title"));
//        contentText.setText((String)data.get("content"));

        Article art = gson.fromJson(json,Article.class);
        titleText.setText(art.title);
        contentText.setText(art.content);

        Button button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveJson();
            }
        });
    }

    private void saveJson() {
        String title = titleText.getEditableText().toString();
        String content = contentText.getEditableText().toString();
        Map<String,String> data = new HashMap<String,String>();
        data.put("title",title);
        data.put("content", content);
//        JSONObject json = new JSONObject(data);
//        resultText.setText(json.toString());

        resultText.setText(gson.toJson(data));

    }
}
