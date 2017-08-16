package org.androidtown.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class NewActivity1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

    }
    public void onButton1_1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(),NewActivity1_1.class);
        startActivity(intent);
    }

}