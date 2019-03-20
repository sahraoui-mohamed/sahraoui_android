package com.example.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.projet.MainActivity.db;
import static com.example.projet.MainActivity.getAppFirstInstallTime;
import static com.example.projet.MainActivity.getDate;

public class Main3Activity extends AppCompatActivity {
    Long date;
    TextView t,dateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t=findViewById(R.id.total);
        t.setText(Float.toString(db.total()));
        date=getAppFirstInstallTime(this);
        String d=getDate("dd/MM/yyyy");
        dateview=findViewById(R.id.ddd);
        dateview.setText(d);
    }

    @Override
    protected void onResume() {
        super.onResume();
        t.setText(Float.toString(db.total()));
    }
}
