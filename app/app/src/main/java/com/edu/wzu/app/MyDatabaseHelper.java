package com.edu.wzu.app;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_MEDIA = "CREATE TABLE Media (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "type TEXT," + // 新增類型欄位來區分是圖片還是影片
            "uri TEXT)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MEDIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Media");
        onCreate(db);
    }

    // 新增存儲 URI 的方法，包括類型參數
    public void storeUri(String type, String uri) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", type);
        values.put("uri", uri);
        db.insert("Media", null, values);
        db.close();
    }

    // 删除指定 URI 的方法
    public void deleteUri(String uri) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Media", "uri = ?", new String[]{uri});
        db.close();
    }


    // 存储 URI 到数据库，并指定 type
    public long insertMedia(String uri, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uri", uri);
        values.put("type", type);  // 存储 type
        long id = db.insert("Media", null, values);
        db.close();
        return id;
    }
}
