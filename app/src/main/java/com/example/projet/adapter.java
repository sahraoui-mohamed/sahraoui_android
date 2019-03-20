package com.example.projet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<ajouter> {
    private ArrayList<ajouter> arrayList;
    private Context ctx;
    private int item;

    public adapter(@NonNull Context context, int resource , ArrayList<ajouter> myarray){
        super(context,resource,myarray);
        this.arrayList=myarray;
        this.ctx=context;
        this.item=resource;
    }

    @NonNull
    @Override
    public boolean isEnabled(int position){ return true;}

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);
        TextView prix=convertView.findViewById(R.id.cprix);
        TextView achat=convertView.findViewById(R.id.cachat);
        TextView date=convertView.findViewById(R.id.cdate);
        prix.setText(Float.toString(arrayList.get(position).getPrix()));
        achat.setText(arrayList.get(position).getAchat());
        date.setText(arrayList.get(position).getDate());
        return convertView;

    }
}
