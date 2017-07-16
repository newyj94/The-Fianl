package org.androidtown.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void onButton1Clicked(View v){
    Intent intent = new Intent(getApplicationContext(),NewActivity.class);
    startActivity(intent);
}
    public void onButton2Clicked(View v){
        Intent intent1 = new Intent(getApplicationContext(),NewActivity2.class);
        startActivity(intent1);
    }
    public void onButton3Clicked(View v){
        Intent intent2 = new Intent(getApplicationContext(),NewActivity3.class);
        startActivity(intent2);
    }
    public void onButton4Clicked(View v){
        Intent intent3 = new Intent(getApplicationContext(),NewActivity4.class);
        startActivity(intent3);
    }
    public void onButton5Clicked(View v){
        Intent intent4 = new Intent(getApplicationContext(),NewActivity5.class);
        startActivity(intent4);
    }
}

