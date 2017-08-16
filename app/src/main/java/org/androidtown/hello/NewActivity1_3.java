package org.androidtown.hello;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static org.androidtown.hello.R.id.text;


public class NewActivity1_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        Intent intent = new Intent(getApplicationContext(),NewActivity1_3_listitem.class);
        startActivity(intent);
    }
}