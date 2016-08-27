package org.shenit.tutorial.android.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import org.shenit.tutorial.android.R;

/**
 * Created by jiangnan on 8/27/16.
 */

public class CustomDrawingView extends View {
    public String shape = "none";
    public int background;
    public String style = "stroke";
    public int color = Color.BLUE;
    public int strokeWidth = 1;

    public CustomDrawingView(Context context) {
        super(context);
    }

    public CustomDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //Here's the example to show how to customize your view's drawing
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(getStyle());
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        switch(shape){
            case "square": {
                canvas.drawRect(100,100,800,800, paint);
                break;
            }
            case "circle":
                canvas.drawCircle(300, 300, 200, paint);
                break;
            case "bitmap":
                BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.small, getContext().getTheme());
                canvas.drawBitmap(drawable.getBitmap(), 0, 0, null);
                break;
            case "arc":
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(3);
                canvas.drawArc(0,0,500,500,0,360,false,paint);
                break;
            case "text":
                canvas.drawText("Hello World!",100,100,paint);
                break;
            default:
                //clear the view
                paint.setAlpha(0);
                canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        }
    }

    private Paint.Style getStyle() {
        Paint.Style paintStyle = null;
        switch(style){
        case "fill":
            paintStyle = Paint.Style.FILL;
            break;
        case "both":
            paintStyle= Paint.Style.FILL_AND_STROKE;
            break;
        default:
            paintStyle= Paint.Style.STROKE;
        }
        return paintStyle;
    }
}
