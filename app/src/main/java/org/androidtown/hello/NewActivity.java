package org.androidtown.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

    }
public void onButton1_3Clicked(View v) {
    Intent intent = new Intent(getApplicationContext(),NewActivity1_3.class);
    startActivity(intent);
    finish();
}
}
