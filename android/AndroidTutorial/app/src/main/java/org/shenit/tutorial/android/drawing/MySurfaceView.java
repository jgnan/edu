package org.shenit.tutorial.android.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jiangnan on 9/18/16.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback  {
    private MainThread thread;
    private Set<Comment> comments;
    private Random rand;
    private TextPaint textPaint;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        this.thread = new MainThread();
        this.thread.surfaceView = this;
        comments = new HashSet<>();
        rand = new Random();
        textPaint = new TextPaint();
        textPaint.setTextSize(65f);
    }

    public void addComment(String comment){
        comments.add(new Comment(
                comment,
                - comment.length() * 10,
                rand.nextInt(getMeasuredHeight())));
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){
            try {
                thread.join();
                retry = false;
            }catch(Exception ex){

            }
        }

    }

    private class Comment{
        private String comment;
        private int x;
        private int y;
        private Comment(String comment, int x, int y){
            this.comment = comment;
            this.x = x;
            this.y = y;
        }
    }

    private class MainThread extends Thread{
        private MySurfaceView surfaceView;

        public void run(){
            while(true){
                Canvas canvas = surfaceView.getHolder().lockCanvas();
                if(canvas == null) return;
                canvas.drawRGB(255,255,255);
                List<Comment> copy = new ArrayList<>(comments);
                for(Comment comment : copy){
                    canvas.drawText(comment.comment,comment.x, comment.y,textPaint);
                    comment.x += 10;
                    if(comment.x >= getMeasuredWidth()) comments.remove(comment);
                }
                //update it
                surfaceView.getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }

}
