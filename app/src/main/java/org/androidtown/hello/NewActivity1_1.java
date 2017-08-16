package org.androidtown.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NewActivity1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

    }
    public void onButton1_1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(),NewActivity1_1.class);
        startActivity(intent);
    }
    public void onButton1_2Clicked(View v){
        Intent intent2 = new Intent(getApplicationContext(),NewActivity1_2.class);
        startActivity(intent2);
    }
    public void onButton1_3Clicked(View v){
        Intent intent3 = new Intent(getApplicationContext(),NewActivity1_3.class);
        startActivity(intent3);
    }
    public void onButton1_4Clicked(View v){
        Intent intent4 = new Intent(getApplicationContext(),NewActivity1_4.class);
        startActivity(intent4);
    }
}