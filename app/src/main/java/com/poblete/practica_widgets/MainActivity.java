package com.poblete.practica_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnIr;
    private CheckBox cbSi, cbNo, cbQuizas;
    private RadioGroup rbGroup;
    private RatingBar ratingBar;
    private String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlazar el boton
        btnIr = findViewById(R.id.btnIr);
        cbSi = findViewById(R.id.cbSi);
        cbNo = findViewById(R.id.cbNo);
        cbQuizas = findViewById(R.id.cbQuizas);
        rbGroup = findViewById(R.id.rbGroup);
        ratingBar = findViewById(R.id.ratingBar);

        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(R.id.rbFem == i){
                    genero = "Femenino";
                }else{
                    genero = "Masculino";
                }
                Toast.makeText(MainActivity.this, "Género: "+genero,Toast.LENGTH_LONG).show();
            }
        });
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float estrellas = ratingBar.getRating();
                Toast.makeText(MainActivity.this, "Valoración: "+estrellas,Toast.LENGTH_LONG).show();

                //cambio de activity
                Intent intent = new Intent(MainActivity.this,Sorpresa.class);
                startActivity(intent);

            }
        });
    }
}