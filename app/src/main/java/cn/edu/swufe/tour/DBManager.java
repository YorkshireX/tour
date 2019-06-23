package cn.edu.swufe.tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private DBHelper dbHelper;
    private String TBNAME;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(GuZhenItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("gzplace", item.getGzPlace());
        values.put("gztime", item.getGzTime());
        values.put("gzroute", item.getGzRoute());
        values.put("gzticket", item.getGzTicket());
        values.put("gzmedi", item.getGzMedi());
        values.put("gzcloth", item.getGzCloth());
        values.put("gzcard", item.getGzCard());
        values.put("gzsun", item.getGzSun());
        values.put("gzrain", item.getGzRain());
        values.put("gzother", item.getGzOther());

        db.insert(TBNAME, null, values);
        db.close();
    }

    public void addAll(List<GuZhenItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (GuZhenItem item : list) {
            ContentValues values = new ContentValues();
            values.put("gzplace", item.getGzPlace());
            values.put("gztime", item.getGzTime());
            values.put("gzroute", item.getGzRoute());
            values.put("gzticket", item.getGzTicket());
            values.put("gzmedi", item.getGzMedi());
            values.put("gzcloth", item.getGzCloth());
            values.put("gzcard", item.getGzCard());
            values.put("gzsun", item.getGzSun());
            values.put("gzrain", item.getGzRain());
            values.put("gzother", item.getGzOther());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(GuZhenItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("gzplace", item.getGzPlace());
        values.put("gztime", item.getGzTime());
        values.put("gzroute", item.getGzRoute());
        values.put("gzticket", item.getGzTicket());
        values.put("gzmedi", item.getGzMedi());
        values.put("gzcloth", item.getGzCloth());
        values.put("gzcard", item.getGzCard());
        values.put("gzsun", item.getGzSun());
        values.put("gzrain", item.getGzRain());
        values.put("gzother", item.getGzOther());
        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public List<GuZhenItem> listAll(){
        List<GuZhenItem> rateList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            rateList = new ArrayList<GuZhenItem>();
            while(cursor.moveToNext()){
                GuZhenItem item = new GuZhenItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setGzPlace(cursor.getString(cursor.getColumnIndex("GZPLACE")));
                item.setGzTime(cursor.getString(cursor.getColumnIndex("GZTIME")));
                item.setGzRoute(cursor.getString(cursor.getColumnIndex("GZROUTE")));
                item.setGzTicket(cursor.getString(cursor.getColumnIndex("GZTICKET")));
                item.setGzMedi(cursor.getString(cursor.getColumnIndex("GZMEDI")));
                item.setGzCloth(cursor.getString(cursor.getColumnIndex("GZCLOTH")));
                item.setGzCard(cursor.getString(cursor.getColumnIndex("GZCARD")));
                item.setGzSun(cursor.getString(cursor.getColumnIndex("GZSUN")));
                item.setGzRain(cursor.getString(cursor.getColumnIndex("GZRAIN")));
                item.setGzOther(cursor.getString(cursor.getColumnIndex("GZOTHER")));


                rateList.add(item);
            }
            cursor.close();
        }
        db.close();
        return rateList;

    }

    public GuZhenItem findById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        GuZhenItem rateItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            rateItem = new GuZhenItem();
            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            rateItem.setGzPlace(cursor.getString(cursor.getColumnIndex("GZPLACE")));
            rateItem.setGzTime(cursor.getString(cursor.getColumnIndex("GZTIME")));
            rateItem.setGzRoute(cursor.getString(cursor.getColumnIndex("GZROUTE")));
            rateItem.setGzTicket(cursor.getString(cursor.getColumnIndex("GZTICKET")));
            rateItem.setGzMedi(cursor.getString(cursor.getColumnIndex("GZMEDI")));
            rateItem.setGzCloth(cursor.getString(cursor.getColumnIndex("GZCLOTH")));
            rateItem.setGzCard(cursor.getString(cursor.getColumnIndex("GZCARD")));
            rateItem.setGzSun(cursor.getString(cursor.getColumnIndex("GZSUN")));
            rateItem.setGzRain(cursor.getString(cursor.getColumnIndex("GZRAIN")));
            rateItem.setGzOther(cursor.getString(cursor.getColumnIndex("GZOTHER")));
            cursor.close();
        }
        db.close();
        return rateItem;
    }
}
