package org.shenit.tutorial.android.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;

import org.shenit.tutorial.android.R;

public class SurfaceViewExampleActivity extends AppCompatActivity{
    private MySurfaceView surfaceView;
    private EditText commentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_example);
        commentText = (EditText) findViewById(R.id.comment);
        surfaceView = (MySurfaceView) findViewById(R.id.surface_view);
    }
    public void onSubmitClick(View view){
        String comment = commentText.getText().toString();
        surfaceView.addComment(comment);
    }
}
