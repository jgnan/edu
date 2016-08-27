package org.shenit.tutorial.android.drawing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.ValueBar;

import org.shenit.tutorial.android.R;

/**
 * Canvas relative topics
 */
public class CanvasExampleActivity extends AppCompatActivity {
    private Spinner shapes;
    private Spinner styles;
    private EditText strokeWidth;
    private ValueBar colorPicker;
    private CustomDrawingView custView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_example);
        shapes = (Spinner) findViewById(R.id.shapes);
        styles = (Spinner) findViewById(R.id.styles);
        strokeWidth = (EditText) findViewById(R.id.stroke_width);
        colorPicker = (ValueBar) findViewById(R.id.color_picker);
        custView = (CustomDrawingView) findViewById(R.id.cust_view);

        shapes.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, new String[]{"none","square","circle","arc","bitmap","text"}));
        styles.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, new String[]{"stoke","fill","both"}));
    }

    public void onApply(View v){
        custView.shape = (String) shapes.getSelectedItem();
        custView.style = (String) styles.getSelectedItem();
        custView.strokeWidth = 1;
        try{
            custView.strokeWidth = Integer.parseInt(strokeWidth.getText().toString());
        }catch(Exception ex){}  //ignore

        custView.color = colorPicker.getColor();

        custView.invalidate();      //repaint it immediately
    }
}
