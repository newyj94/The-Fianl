package org.androidtown.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class NewActivity1_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {

    SpinnerList list;
    TextView textView1;

    // List view
    private ListView lv;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    // Search EditText
    EditText inputSearch;
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1_3);



        String products[] = {"1", "2", "3", "4", "5",
                "6", "7","8", "9", "10"};
        lv = (ListView) findViewById(R.id.list_view);
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.activity_new1_3_listitem, R.id.product_name, products);
        lv.setAdapter(adapter);


        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                NewActivity1_3.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // TODO Auto-generated method stub
            }

        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String medItem = list.getitems(position);
        textView1.setText(medItem);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textView1.setText("선택해주세요");
    }
    public void onButton1_3searchClicked(View v) {
        Intent intent = new Intent(getApplicationContext(),NewActivity1_3.class);
        startActivity(intent);
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
            Intent intent2 = new Intent(getApplicationContext(),NewActivity3main.class);
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