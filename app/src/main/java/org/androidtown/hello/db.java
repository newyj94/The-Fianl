package org.androidtown.hello;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yujin on 2017-07-31.
 */

public class db extends SQLiteOpenHelper{
    public db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
     super(context,name, factory, version);
    }
    public void onCreate(SQLiteDatabase data){
        data.execSQL("CREATE TABLE MyMedicine(name TEXT PRIMARY KEY,"+" medicine TEXT AUTO INCREMENT);");
    }
public void onUpgrade(SQLiteDatabase data, int oldVersion, int newVersion){
    data.execSQL("DROP TABLE IF EXISTS medicine");
    onCreate(data);

}



}
