package org.androidtown.hello;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;


public class NewActivity1_4_listitem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp1,sp2,sp3,sp4;

    ArrayAdapter adapter1,adapter2,adapter3,adapter4;


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
        setContentView(R.layout.activity_new1_4);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.jungjae_array,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1 = (Spinner)findViewById(R.id.spinner_jungjae);
        sp1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.color_array,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2 = (Spinner)findViewById(R.id.spinner_color);
        sp2.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.form_array,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3 = (Spinner)findViewById(R.id.spinner_form);
        sp3.setAdapter(adapter3);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.symbol_array,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4 = (Spinner)findViewById(R.id.spinner_symbol);
        sp4.setAdapter(adapter4);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    //    String medItem = list.getitems(position);
   //     inputSearch.setText(medItem);
    }
    public void onNothingSelected(AdapterView<?> parent) {
        //textView1.setText("선택해주세요");
    }

    public void onButton1_4search(View v) {
        Intent intent = new Intent(getApplicationContext(),NewActivity1_4_listitem.class);
        startActivity(intent);
    }

}