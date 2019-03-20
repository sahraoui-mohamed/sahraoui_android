package com.example.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ajouter extends AppCompatActivity {

    int id;
    public static float total;
    private String achat;
    private Float prix;
    String date;

    public ajouter(String achat,Float prix){
        this.achat=achat;
        this.prix=prix;
        String pattern ="MM/dd/yyyy HH:mm:ss";
        DateFormat df=new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        date=df.format(today);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float total) {
        ajouter.total = total;
    }

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
