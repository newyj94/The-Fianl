package org.androidtown.hello;


import android.app.Activity;
import android.content.Intent;
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
import android.widget.EditText;

public class NewActivity3_1 extends Activity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

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

         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         //    setSupportActionBar(toolbar);


         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                 this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
         drawer.setDrawerListener(toggle);
         toggle.syncState();

         NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);


    }

            public void onClick(View v) {


                 if (v.getId() == R.id.button_list){


                        Intent it = new Intent(this,NewActivity3.class);
                         startActivity(it);
                         finish();
                    }
                 EditText et_medicine = (EditText)findViewById(R.id.edit_medicine);
                 String str_medicine = et_medicine.getText().toString();




               try{
                        dbhp = new DBHelper(this);


                        SQLiteDatabase sdb;


                         sdb = dbhp.getWritableDatabase();
                         sdb.execSQL("Insert into customer values(null, '"+ str_medicine +"');");
                         dbhp.close();
                     }catch (SQLiteException e){


                    }
                Intent it = new Intent(this,NewActivity3.class);
               startActivity(it);
        finish();
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


           }
