package org.androidtown.hello;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

public class NewActivity3 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
         String dbName = "medicine.db";
        setTitle("내 약정보");

        LinearLayout layout =(LinearLayout) findViewById(R.id.customer);
        int i = 0;
        try{
            DBHelper dbhp = new DBHelper(this);
            SQLiteDatabase sdb = dbhp.getReadableDatabase();
            Cursor cursor = sdb.rawQuery("Select medicine from customer",null);

            while(cursor.moveToNext()){

                String medicine = cursor.getString(0);

               // TextView tv_list = new TextView(this);
              //  tv_list.append(name);
               // tv_list.setTextSize(20);
               // tv_list.setTextColor(Color.rgb(255,255,0));
               // tv_list.setBackgroundColor(Color.rgb(0,0,255));
               // layout.addView(tv_list);

                TextView tv_list2 = new TextView(this);
                tv_list2.append(medicine + "\n");
                layout.addView(tv_list2);
                i++;
            }
            if(i==0){
                TextView tv_desc = new TextView(this);
              //  tv_desc.append("");
                layout.addView(tv_desc);
            }
            cursor.close();
            dbhp.close();
        }catch (SQLiteException e) {
            TextView tv_err = new TextView(this);
            tv_err.append(e.getMessage());
            layout.addView(tv_err);
        }
        Button btn = (Button)findViewById(R.id.Button_medicine_plus);
        btn.setOnClickListener(this);
    }


    public void onClick(View v) {
       Intent it = new Intent(this, NewActivity3_1.class);
        startActivity(it);
        finish();

    }

}

