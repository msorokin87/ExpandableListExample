package com.android.expandablelistexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public Context context;
    public static final String DATABASE_NAME = "Goods.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "my_lists";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "goods_title";
    public static final String COLUMN_DESC = "goods_desc";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESC + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addGoods(String title, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESC, desc);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result ==-1) {
            Toast.makeText(context, "Не получилось сохранить", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Сохранено", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        } return cursor;
    }

    void updateData (String row_id, String title, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESC, desc);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if (result==-1) {
            Toast.makeText(context, "Не получилось обновить", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Изменения сохранены", Toast.LENGTH_SHORT).show();
        }

    }
    void updateOnePosition(String edit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DESC, edit);
        long result = db.update(TABLE_NAME, cv, "goods_title=?", new String[]{edit});
        if (result==-1) {
            Toast.makeText(context, "Не получилось обновить desc", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Desc сохранен", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRaw (String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "goods_title=?", new String[]{title});
        if (result ==-1) {
            Toast.makeText(context, "Не получилось удалить", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Удалено", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
