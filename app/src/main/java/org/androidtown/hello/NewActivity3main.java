package org.androidtown.hello;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewActivity3maybe extends ActionBar {

    private DBHelper dbhp;
    TextView medicine;

    int _id = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        medicine = (TextView) medicine.findViewById(R.id.edit_medicine);
        dbhp = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("_id");
            if (Value > 0) {
                Cursor rs = dbhp.getData(Value);
                _id = Value;
                rs.moveToFirst();
                String n = rs.getString(rs.getColumnIndex(DBHelper.CUSTOMER_COLUMN_MEDICINE));
                if (!rs.isClosed()) {
                    rs.close();
                }
                Button b = (Button) findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);

                medicine.setText((CharSequence) m);
            }
        }

    }

    public void insert(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("_id");
            if (Value > 0) {
                if (dbhp.updateCustomer(_id, medicine.getText().toString())) {
                    Toast.makeText(getApplicationContext, "수정되었음", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), NewActivity3.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "수정되지 않았음", Toast.LENGTH_SHORT).show();
                }else{
                    if (dbhp.insertCustomer(medicine.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "추가되었음", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "추가되지 않았음", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            }
        }

    }
    public void delete(View view) {

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                int Value = extras.getInt("_id");
                if (Value > 0) {
                dbhp.deleteMedicine(_id)
                        Toast.makeText(getApplicationContext, "삭제되었음", Toast.LENGTH_SHORT).show();
                finish();
                } else {
                        Toast.makeText(getApplicationContext(), "삭제되지 않았음", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    public void edit(View view) {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("_id");
            if (Value > 0) {
                if (dbhp.updateCustomer(_id, medicine.getText().toString())) {
                Toast.makeText(getApplicationContext, "수정되었음", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "수정되지 않았음", Toast.LENGTH_SHORT).show();
            }
        }
    }
    }
    @Override
    public void setCustomView(View view) {

    }

    @Override
    public void setCustomView(View view, LayoutParams layoutParams) {

    }

    @Override
    public void setCustomView(int resId) {

    }

    @Override
    public void setIcon(int resId) {

    }

    @Override
    public void setIcon(Drawable icon) {

    }

    @Override
    public void setLogo(int resId) {

    }

    @Override
    public void setLogo(Drawable logo) {

    }

    @Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {

    }

    @Override
    public void setSelectedNavigationItem(int position) {

    }

    @Override
    public int getSelectedNavigationIndex() {
        return 0;
    }

    @Override
    public int getNavigationItemCount() {
        return 0;
    }

    @Override
    public void setTitle(CharSequence title) {

    }

    @Override
    public void setTitle(int resId) {

    }

    @Override
    public void setSubtitle(CharSequence subtitle) {

    }

    @Override
    public void setSubtitle(int resId) {

    }

    @Override
    public void setDisplayOptions(int options) {

    }

    @Override
    public void setDisplayOptions(int options, int mask) {

    }

    @Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {

    }

    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {

    }

    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {

    }

    @Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {

    }

    @Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {

    }

    @Override
    public void setBackgroundDrawable(Drawable d) {

    }

    @Override
    public View getCustomView() {
        return null;
    }

    @Override
    public CharSequence getTitle() {
        return null;
    }

    @Override
    public CharSequence getSubtitle() {
        return null;
    }

    @Override
    public int getNavigationMode() {
        return 0;
    }

    @Override
    public void setNavigationMode(int mode) {

    }

    @Override
    public int getDisplayOptions() {
        return 0;
    }

    @Override
    public Tab newTab() {
        return null;
    }

    @Override
    public void addTab(Tab tab) {

    }

    @Override
    public void addTab(Tab tab, boolean setSelected) {

    }

    @Override
    public void addTab(Tab tab, int position) {

    }

    @Override
    public void addTab(Tab tab, int position, boolean setSelected) {

    }

    @Override
    public void removeTab(Tab tab) {

    }

    @Override
    public void removeTabAt(int position) {

    }

    @Override
    public void removeAllTabs() {

    }

    @Override
    public void selectTab(Tab tab) {

    }

    @Override
    public Tab getSelectedTab() {
        return null;
    }

    @Override
    public Tab getTabAt(int index) {
        return null;
    }

    @Override
    public int getTabCount() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public boolean isShowing() {
        return false;
    }

    @Override
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {

    }

    @Override
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {

    }


}

