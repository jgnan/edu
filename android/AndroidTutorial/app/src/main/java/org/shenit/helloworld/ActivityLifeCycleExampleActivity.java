package org.shenit.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityLifeCycleExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_content);
        System.out.println("---> onCreate called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("---> onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("---> onDestroy called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("---> onPause called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("---> onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("---> onResume called");
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---> onStart called");
    }

}
