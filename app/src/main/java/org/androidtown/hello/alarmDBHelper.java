package org.androidtown.hello;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class alarmDBHelper extends SQLiteOpenHelper{

    public alarmDBHelper(Context context){
        super(context,"ourDB",null,1);
    }
    public void onCreate(SQLiteDatabase data){
        data.execSQL("CREATE TABLE customer(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+" medicine TEXT);");
    }
    public void onUpgrade(SQLiteDatabase data, int oldVersion, int newVersion){
        data.execSQL("DROP TABLE IF EXISTS medicine");
        onCreate(data);

    }

}
