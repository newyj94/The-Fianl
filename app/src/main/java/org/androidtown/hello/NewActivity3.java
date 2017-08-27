package org.androidtown.hello;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewActivity3 extends Activity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_share) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_search) {
            Intent intent = new Intent(getApplicationContext(),NewActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_alarm) {
            Intent intent1 = new Intent(getApplicationContext(),NewActivity2.class);
            startActivity(intent1);
        } else if (id == R.id.nav_mypage) {
            Intent intent2 = new Intent(getApplicationContext(),NewActivity3.class);
            startActivity(intent2);
        } else if (id == R.id.nav_near_pharm) {
            Intent intent3 = new Intent(getApplicationContext(),NewActivity4.class);
            startActivity(intent3);
        } else if (id == R.id.nav_diagnose) {
            Intent intent4 = new Intent(getApplicationContext(),NewActivity5.class);
            startActivity(intent4);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawers();

        return true;

    }



    public void onClick(View v) {
       Intent it = new Intent(this, NewActivity3_1.class);
        startActivity(it);
        finish();

    }

}

