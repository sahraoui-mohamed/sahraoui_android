package com.example.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.projet.MainActivity.db;

public class Main2Activity extends AppCompatActivity {

    Button btn;
    EditText achat;
    EditText prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn=findViewById(R.id.btn);
        achat=findViewById(R.id.aaa);
        prix=findViewById(R.id.bbb);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String achats =achat.getText().toString();
                Float prixx=Float.valueOf(prix.getText().toString());
                ajouter nouveau =new ajouter(achats,prixx);
                db.ajoutdepense(nouveau);
                Toast.makeText(Main2Activity.this,"ajouter",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
