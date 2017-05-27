package com.example.alanc.appfightingfantasycharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alanc.appfightingfantasycharacter.R;
import com.example.alanc.appfightingfantasycharacter.dao.EquipDao;
import com.example.alanc.appfightingfantasycharacter.dao.bd.EquipDaoBd;
import com.example.alanc.appfightingfantasycharacter.model.Equip;

public class CadastroNovoItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_item);
    }

    public void cadastrar(View v){
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextDescricao = (EditText) findViewById(R.id.editTextDescricao);
        Equip equip = new Equip(editTextNome.getText().toString(),
                editTextDescricao.getText().toString());
        EquipDao dao = new EquipDaoBd(this);
        dao.inserir(equip);
        Toast.makeText(this,"Novo item cadastrado com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void cancelar(View v){
        finish();
    }

}