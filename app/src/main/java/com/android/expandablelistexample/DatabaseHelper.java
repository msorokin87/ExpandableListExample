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
    public static final String TABLE_NAME_DESC = "my_desc";
    public static final String COLUMN_ID_DESC = "_id";
    public static final String TABLE_NAME_DESC_NEW = "my_desc_new";
    public static final String COLUMN_ID_DESC_NEW = "_id";

    public static final String TABLE_NAME_SORT = "my_sort";


    public static final String COLUMN_ID_SORT = "_id";


    public static final String COLUMN_NAME_SORT = "name";
    public static final String COLUMN_NAME_DESC_D = "name";
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

    public static final String COLUMN_ONE_D = "one";
    public static final String COLUMN_TWO_D = "two";
    public static final String COLUMN_THREE_D = "three";
    public static final String COLUMN_FOUR_D = "four";
    public static final String COLUMN_FIFE_D = "fife";
    public static final String COLUMN_SIX_D = "six";
    public static final String COLUMN_SEVEN_D = "seven";
    public static final String COLUMN_EITH_D = "eith";
    public static final String COLUMN_NINE_D = "nine";
    public static final String COLUMN_THENE_D = "thene";
    public static final String COLUMN_ELEVEN_D = "eleven";
    public static final String COLUMN_TWELVE_D = "twelve";

    public static final String COLUMN_TITLE = "goods_title";
    public static final String COLUMN_DESC = "goods_desc";
    public static final String COLUMN_DESC_ONE = "goods_desc_new";
    public static final String COLUMN_GROOP = "groop";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT);";

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

        String query3 = "CREATE TABLE " + TABLE_NAME_DESC +
                " (" + COLUMN_ID_DESC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESC_ONE + " TEXT);";

        String query4 = "CREATE TABLE " + TABLE_NAME_DESC_NEW +
                " (" + COLUMN_ID_DESC_NEW + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_DESC_D + " TEXT, " +
                COLUMN_ONE_D + " TEXT, " +
                COLUMN_TWO_D + " TEXT, " +
                COLUMN_THREE_D + " TEXT, " +
                COLUMN_FOUR_D + " TEXT, " +
                COLUMN_FIFE_D + " TEXT, " +
                COLUMN_SIX_D + " TEXT, " +
                COLUMN_SEVEN_D + " TEXT, " +
                COLUMN_EITH_D + " TEXT, " +
                COLUMN_NINE_D + " TEXT, " +
                COLUMN_THENE_D + " TEXT, " +
                COLUMN_ELEVEN_D + " TEXT, " +
                COLUMN_TWELVE_D + " TEXT);";


        db.execSQL(query);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SORT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DESC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DESC_NEW);
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
    void addAllinDesc(String one_d,String two_d,String three_d,String four_d,String fife_d,
                      String six_d,String seven_d,String eith_d,String nine_d,String thene_d,
                      String eleven_d,String tvelve_d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ONE_D, one_d);
        cv.put(COLUMN_TWO_D, two_d);
        cv.put(COLUMN_THREE_D, three_d);
        cv.put(COLUMN_FOUR_D, four_d);
        cv.put(COLUMN_FIFE_D, fife_d);
        cv.put(COLUMN_SIX_D, six_d);
        cv.put(COLUMN_SEVEN_D, seven_d);
        cv.put(COLUMN_EITH_D, eith_d);
        cv.put(COLUMN_NINE_D, nine_d);
        cv.put(COLUMN_THENE_D, thene_d);
        cv.put(COLUMN_ELEVEN_D, eleven_d);
        cv.put(COLUMN_TWELVE_D, tvelve_d);

        long result = db.insert(TABLE_NAME_DESC_NEW, null, cv);
        if (result ==-1) {
            Toast.makeText(context, "Не вышло в Сорт", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "В Сорт", Toast.LENGTH_SHORT).show();
        }
    }

    void addGoods(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result ==-1) {
            Toast.makeText(context, "Не получилось сохранить", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Сохранено", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    void addDesc(String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DESC_ONE, desc);

        long result = db.insert(TABLE_NAME_DESC, null, cv);
        if (result ==-1) {
            Toast.makeText(context, "Не добавилось в деск", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Добавилось в деск", Toast.LENGTH_SHORT).show();
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
    Cursor readAllDesc() {
        String query = "SELECT * FROM " + TABLE_NAME_DESC;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        } return cursor;
    }

    Cursor readAllDesc_New() {
        String query = "SELECT * FROM " + TABLE_NAME_DESC_NEW;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        } return cursor;
    }

    Cursor readAllByID (String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{COLUMN_ID_SORT};
        String selection ="_id";
        String[] selectionArgs = new String[]{id};

        Cursor cursor =  db.query(TABLE_NAME_SORT, new String[]{COLUMN_ID_SORT}, "_id" + "=?", selectionArgs, null, null, null,
                null);

        return cursor;

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

    void deleteOneRawDesc (String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_DESC, "goods_desc_new=?", new String[]{title});
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
    void deleteAllDataDesc() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME_DESC);
    }
}
