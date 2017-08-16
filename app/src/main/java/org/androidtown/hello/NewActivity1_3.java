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


public class NewActivity1_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp1,sp2,sp3,sp4;
    SpinnerList list,list2,list3,list4;
    ArrayAdapter adapter1,adapter2,adapter3,adapter4;
    TextView textView1,textView2,textView3,textView4;

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