package com.example.alanc.appfightingfantasycharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_dado;
    ImageView i_dado1, i_dado2;

    Random ran;
    int numDado1, numDado2;

    int novoJogo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_dado = (Button) findViewById(R.id.b_dado);
        i_dado1 = (ImageView) findViewById(R.id.i_dado1);
        i_dado2 = (ImageView) findViewById(R.id.i_dado2);

        ran = new Random();

        if (novoJogo == 1) {
            Intent it = new Intent(this,DefinirStatus.class);
            startActivity(it);
        }
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

}