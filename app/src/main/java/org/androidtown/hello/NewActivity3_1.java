package org.androidtown.hello;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewActivity3_1 extends Activity implements View.OnClickListener {

    private DBHelper dbhp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_form);

        setTitle("내 약 추가");

        Button btn_store = (Button) findViewById(R.id.button_store);
        btn_store.setOnClickListener(this);

        Button btn_list = (Button) findViewById(R.id.button_list);
        btn_list.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v.getId() == R.id.button_list){

            Intent it = new Intent(this,NewActivity3.class);
            startActivity(it);
            finish();
        }
        EditText et_name = (EditText)findViewById(R.id.edit_name);
        String str_name = et_name.getText().toString();

        EditText et_medicine = (EditText)findViewById(R.id.edit_medicine);
        String str_medicine = et_medicine.getText().toString();

        try{
            dbhp = new DBHelper(this);

            SQLiteDatabase sdb;

            sdb = dbhp.getWritableDatabase();
            sdb.execSQL("Insert into customer values('" + str_name+"','"+str_medicine+"');");
            dbhp.close();
        }catch (SQLiteException e){

        }
        Intent it = new Intent(this,NewActivity3.class);
        startActivity(it);
        finish();
    }

    }

