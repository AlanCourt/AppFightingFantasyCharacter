package com.example.alanc.appfightingfantasycharacter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DefinirStatus extends AppCompatActivity {

    Button b_dadoHab, b_dadoEne, b_dadoSor, b_continue;
    /*ImageView i_dado1, i_dado2;*/
    TextView hab, ene, sor;

    Random ran;
    int numDado1, numDado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definir_status);

        b_dadoHab = (Button) findViewById(R.id.b_dadoHab);
        b_dadoEne = (Button) findViewById(R.id.b_dadoEne);
        b_dadoSor = (Button) findViewById(R.id.b_dadoSor);
        b_continue = (Button) findViewById(R.id.b_continue);
        /*i_dado1 = (ImageView) findViewById(R.id.i_dado1);
        i_dado2 = (ImageView) findViewById(R.id.i_dado2);*/

        hab = (TextView) findViewById(R.id.textInicialHab);
        ene = (TextView) findViewById(R.id.textInicialEne);
        sor = (TextView) findViewById(R.id.textInicialSor);

        ran = new Random();

        b_dadoHab.setVisibility(View.VISIBLE);
        b_dadoEne.setVisibility(View.GONE);
        b_dadoSor.setVisibility(View.GONE);
        b_continue.setVisibility(View.GONE);

        /*i_dado1.setVisibility(View.VISIBLE);
        i_dado2.setVisibility(View.GONE);*/
    }

    public  void DadoHab (View v) {
        jogDado();
        hab.setText(String.valueOf(numDado1 + 6));
        b_dadoHab.setVisibility(View.GONE);
        b_dadoEne.setVisibility(View.VISIBLE);
        /*i_dado2.setVisibility(View.VISIBLE);*/
    }

    public  void DadoEne (View v) {
        jogDado();
        ene.setText(String.valueOf(numDado1 + numDado2 + 12));
        b_dadoEne.setVisibility(View.GONE);
        b_dadoSor.setVisibility(View.VISIBLE);
       /*i_dado2.setVisibility(View.GONE);*/
    }

    public  void DadoSor (View v) {
        jogDado();
        sor.setText(String.valueOf(numDado1 + 6));
        b_dadoSor.setVisibility(View.GONE);
        /*i_dado1.setVisibility(View.GONE);*/

        b_continue.setVisibility(View.VISIBLE);
    }

    public void Continue(View v) {
        finish();
    }

    public void jogDado() {
        numDado1 = ran.nextInt(6) + 1;
        numDado2 = ran.nextInt(6) + 1;

      /*  if (numDado1 == 1) {
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
        }*/
    }
}
