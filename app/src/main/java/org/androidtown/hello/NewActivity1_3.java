package org.androidtown.hello;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static org.androidtown.hello.R.id.sp1;
import static org.androidtown.hello.R.id.text;


public class NewActivity1_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp1,sp2,sp3,sp4;
    SpinnerList list,list2,list3,list4;
    ArrayAdapter adapter;
    ArrayAdapter adapter2,adapter3,adapter4;
    TextView textView1,textView2,textView3,textView4;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1_3);

        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);
        sp3 = (Spinner) findViewById(R.id.sp3);
        sp4 = (Spinner) findViewById(R.id.sp4);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);

        list = new SpinnerList();
        list2 = new SpinnerList();
        list3 = new SpinnerList();
        list4 = new SpinnerList();
        adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list.getArrayList());
        adapter2 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list2.getArrayList());
        adapter3 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list3.getArrayList());
        adapter4 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list4.getArrayList());

        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(this);
        sp4.setAdapter(adapter4);
        sp4.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String medItem = list.getitems(position);
        textView1.setText(medItem);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textView1.setText("선택해주세요");

    }

}
