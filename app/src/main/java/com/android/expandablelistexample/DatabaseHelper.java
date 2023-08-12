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

    public static final String TABLE_NAME_SORT = "my_sort";
    public static final String COLUMN_ID_SORT = "_id";
    public static final String COLUMN_NAME_SORT = "name";
    public static final String COLUMN_ONE = "one";
    public static final String COLUMN_TWO = "two";
    public static final String COLUMN_THREE = "three";
    public static final String COLUMN_FOUR = "four";
    public static final String COLUMN_FIFE = "fife";
    public static final String COLUMN_SIX = "six";
    public static final String COLUMN_SEVEN = "seven";
    public static final String COLUMN_EITH = "eith";
    public static final String COLUMN_NINE = "nine";
    public static final String COLUMN_THENE = "thene";
    public static final String COLUMN_ELEVEN = "eleven";
    public static final String COLUMN_TWELVE = "twelve";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "goods_title";
    public static final String COLUMN_DESC = "goods_desc";
    public static final String COLUMN_GROOP = "groop";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_GROOP + " TEXT, " +
                COLUMN_DESC + " TEXT);";

        String query2 = "CREATE TABLE " + TABLE_NAME_SORT +
                " (" + COLUMN_ID_SORT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_SORT + " TEXT, " +
                COLUMN_ONE + " TEXT, " +
                COLUMN_TWO + " TEXT, " +
                COLUMN_THREE + " TEXT, " +
                COLUMN_FOUR + " TEXT, " +
                COLUMN_FIFE + " TEXT, " +
                COLUMN_SIX + " TEXT, " +
                COLUMN_SEVEN + " TEXT, " +
                COLUMN_EITH+ " TEXT, " +
                COLUMN_NINE + " TEXT, " +
                COLUMN_THENE + " TEXT, " +
                COLUMN_ELEVEN + " TEXT, " +
                COLUMN_TWELVE + " TEXT);";


        db.execSQL(query);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SORT);
        onCreate(db);
    }




    void addAllinSort(String one,String two,String three,String four,String fife,
                      String six,String seven,String eith,String nine,String thene,
                      String eleven,String tvelve) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ONE, one);
        cv.put(COLUMN_TWO, two);
        cv.put(COLUMN_THREE, three);
        cv.put(COLUMN_FOUR, four);
        cv.put(COLUMN_FIFE, fife);
        cv.put(COLUMN_SIX, six);
        cv.put(COLUMN_SEVEN, seven);
        cv.put(COLUMN_EITH, eith);
        cv.put(COLUMN_NINE, nine);
        cv.put(COLUMN_THENE, thene);
        cv.put(COLUMN_ELEVEN, eleven);
        cv.put(COLUMN_TWELVE, tvelve);

        long result = db.insert(TABLE_NAME_SORT, null, cv);
        if (result ==-1) {
            Toast.makeText(context, "Не вышло в Сорт", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "В Сорт", Toast.LENGTH_SHORT).show();
        }
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
        db.close();
    }
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);

        }

        return cursor;

    }

    Cursor readAllSort() {
        String query = "SELECT * FROM " + TABLE_NAME_SORT;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        } return cursor;
    }

    Cursor readByGroop (String groop) {

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GROOP + " LIKE " + groop;
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
        db.close();

    }

    void updateGroopName (String row_id, String groop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_GROOP, groop);
        long result = db.update(TABLE_NAME, cv, "goods_title=?", new String[]{row_id});

        if (result==-1) {
            Toast.makeText(context, "NotUpdated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
        }
        db.close();

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

    void deleteAllDataSort() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_SORT);
    }
}
