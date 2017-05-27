package com.example.alanc.appfightingfantasycharacter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alanc.appfightingfantasycharacter.adapter.EquipAdapter;
import com.example.alanc.appfightingfantasycharacter.dao.EquipDao;
import com.example.alanc.appfightingfantasycharacter.dao.bd.EquipDaoBd;
import com.example.alanc.appfightingfantasycharacter.model.Equip;

import java.util.ArrayList;
import java.util.List;

public class Equipamentos extends AppCompatActivity {

    List<Equip> listaEquip = new ArrayList<>();
    EquipAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamentos);

        adaptador = new EquipAdapter(listaEquip,
                this);

        ListView listView = (ListView) findViewById(R.id.listEquip);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Equip equip = listaEquip.get(position);

                        Intent it = new Intent(Equipamentos.this, DetalheItem.class);
                        it.putExtra("equip",equip);
                        startActivity(it);
                    }
                }
        );

    }

    @Override
    public void onResume() {
        super.onResume();
        EquipDao dao = new EquipDaoBd(this);
        listaEquip = dao.listar();
        adaptador.setListaEquip(listaEquip);
        adaptador.notifyDataSetChanged();
    }

    public void abrirNovoItem(View v){
        Intent it = new Intent(this, CadastroNovoItem.class);
        startActivity(it);

    }

    public void voltar(View view){
        finish();
    }
}