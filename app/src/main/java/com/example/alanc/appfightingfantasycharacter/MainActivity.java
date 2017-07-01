package com.example.alanc.appfightingfantasycharacter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alanc.appfightingfantasycharacter.model.Status;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_dado;
    ImageButton maisHab, menosHab, maisEne, menosEne, maisSor, menosSor;
    ImageView i_dado1, i_dado2;
    TextView textHab, textEne, textSor;
    TextView textHabIni, textEneIni, textSorIni;

    Random ran;
    int numDado1, numDado2;

    int valorHab, valorEne, valorSor;
    int valorHabIni, valorEneIni, valorSorIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_dado = (Button) findViewById(R.id.b_dado);
        maisHab = (ImageButton) findViewById(R.id.maisHab);
        menosHab = (ImageButton) findViewById(R.id.menosHab);
        maisEne = (ImageButton) findViewById(R.id.maisEne);
        menosEne = (ImageButton) findViewById(R.id.menosEne);
        maisSor = (ImageButton) findViewById(R.id.maisSor);
        menosSor = (ImageButton) findViewById(R.id.menosSor);

        textHab = (TextView) findViewById(R.id.textHab);
        textEne = (TextView) findViewById(R.id.textEne);
        textSor = (TextView) findViewById(R.id.textSor);

        textHabIni = (TextView) findViewById(R.id.textHabIni);
        textEneIni = (TextView) findViewById(R.id.textEneIni);
        textSorIni = (TextView) findViewById(R.id.textSorIni);

        i_dado1 = (ImageView) findViewById(R.id.i_dado1);
        i_dado2 = (ImageView) findViewById(R.id.i_dado2);

        ran = new Random();

    }

    @Override
    public void onResume() {
        super.onResume();

        ControlLifeCycleAllApp.myRef.child("Status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Status status = dataSnapshot.getValue(Status.class);

                valorHab = status.getHabilidade();
                valorEne = status.getEnergia();
                valorSor = status.getSorte();

                valorHabIni = status.getHabilidadeIni();
                valorEneIni = status.getEnergiaIni();
                valorSorIni = status.getSorteIni();

                textHabIni.setText(String.valueOf(valorHabIni));
                textEneIni.setText(String.valueOf(valorEneIni));
                textSorIni.setText(String.valueOf(valorSorIni));

                textHab.setText(String.valueOf(valorHab));
                textEne.setText(String.valueOf(valorEne));
                textSor.setText(String.valueOf(valorSor));

                if (valorHabIni == 0 && valorEneIni == 0 && valorSorIni == 0) {

                    Intent it = new Intent(MainActivity.this,DefinirStatus.class);
                    startActivity(it);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    public void aumentarHab(View v) {

        valorHab = valorHab + 1;
        textHab.setText(String.valueOf(valorHab));

    }

    public void aumentarEne (View v) {

        valorEne = valorEne + 1;
        textEne.setText(String.valueOf(valorEne));

    }

    public void aumentarSor (View v) {

        valorSor = valorSor + 1;
        textSor.setText(String.valueOf(valorSor));

    }

    public void diminuirHab (View v) {

        valorHab = valorHab - 1;
        textHab.setText(String.valueOf(valorHab));

    }

    public void diminuirEne (View v) {

        valorEne = valorEne - 1;
        textEne.setText(String.valueOf(valorEne));

    }

    public void diminuirSor (View v) {

        valorSor = valorSor - 1;
        textSor.setText(String.valueOf(valorSor));

    }

    public void jogDado(View v) {
        numDado1 = ran.nextInt(6) + 1;
        numDado2 = ran.nextInt(6) + 1;

        if (numDado1 == 1) {
            i_dado1.setImageResource(R.drawable.d1);
        } else if (numDado1 == 2) {
            i_dado1.setImageResource(R.drawable.d2);
        } else if (numDado1 == 3) {
            i_dado1.setImageResource(R.drawable.d3);
        } else if (numDado1 == 4) {
            i_dado1.setImageResource(R.drawable.d4);
        } else if (numDado1 == 5) {
            i_dado1.setImageResource(R.drawable.d5);
        } else if (numDado1 == 6) {
            i_dado1.setImageResource(R.drawable.d6);
        }

        if (numDado2 == 1) {
            i_dado2.setImageResource(R.drawable.d1);
        } else if (numDado2 == 2) {
            i_dado2.setImageResource(R.drawable.d2);
        } else if (numDado2 == 3) {
            i_dado2.setImageResource(R.drawable.d3);
        } else if (numDado2 == 4) {
            i_dado2.setImageResource(R.drawable.d4);
        } else if (numDado2 == 5) {
            i_dado2.setImageResource(R.drawable.d5);
        } else if (numDado2 == 6) {
            i_dado2.setImageResource(R.drawable.d6);
        }
    }

    public void abrirEquipamentos (View v) {
        Intent it = new Intent(this,Equipamentos.class);
        startActivity(it);
    }

    public void novoJogo (View v) {
        Intent it = new Intent(MainActivity.this,DefinirStatus.class);
        startActivity(it);
    }

}