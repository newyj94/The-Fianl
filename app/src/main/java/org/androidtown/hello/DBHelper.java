package org.androidtown.hello;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context){
        super(context,"myDB",null,1);
    }
    public void onCreate(SQLiteDatabase data){
        data.execSQL("CREATE TABLE customer(name TEXT PRIMARY KEY,"+" medicine TEXT AUTO INCREMENT);");
    }
    public void onUpgrade(SQLiteDatabase data, int oldVersion, int newVersion){
        data.execSQL("DROP TABLE IF EXISTS medicine");
        onCreate(data);

    }

}
