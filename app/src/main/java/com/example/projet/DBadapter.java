package com.example.projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBadapter extends SQLiteOpenHelper {
    public DBadapter(Context context){super(context,"projet",null,1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String creaTable ="create table ajouter(id integer primary key,achat text ,prix float,date text)";
        db.execSQL(creaTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable=("drop table if exists ajouter");
        db.execSQL(deleteTable);
        onCreate(db);

    }

    public void ajoutdepense (ajouter nouveau){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("achat",nouveau.getAchat());
        contentValues.put("prix",nouveau.getPrix());
        contentValues.put("date",nouveau.getDate());
        db.insert("ajouter",null,contentValues);
    }

    public ArrayList<ajouter> afficher(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM ajouter";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<ajouter> depenses=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                ajouter nouveau=new ajouter (cursor.getString(1),cursor.getFloat(2));
                nouveau.setId(cursor.getInt(0));
                nouveau.setDate(cursor.getString(3));
                depenses.add(nouveau);
        }while (cursor.moveToNext());
    }return depenses;}

    public void remove(int id){
        SQLiteDatabase db=getReadableDatabase();
        db.delete("ajouter","id="+Integer.toString(id),null);

    }
    public Float total(){
        Float s=0f;
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM ajouter";
        Cursor cursor=db.rawQuery(selectall,null);
        ArrayList<ajouter> depenses=new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                s+=cursor.getFloat(2);
            }while (cursor.moveToNext());
        }return s;
    }

}
