package com.example.alanc.appfightingfantasycharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alanc.appfightingfantasycharacter.R;
import com.example.alanc.appfightingfantasycharacter.model.Equip;

import java.util.UUID;

public class CadastroNovoItem extends AppCompatActivity {

    EditText editTextNome, editTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_item);
    }

    public void cadastrar(View v){
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextDescricao = (EditText) findViewById(R.id.editTextDescricao);

        Equip equip = new Equip();

        equip.setId(UUID.randomUUID().toString());
        equip.setNome(editTextNome.getText().toString());
        equip.setDescricao(editTextDescricao.getText().toString());

        ControlLifeCycleAllApp.myRef.child("Equip").child(equip.getId()).setValue(equip);

        Toast.makeText(this,"Novo item cadastrado com sucesso!",Toast.LENGTH_SHORT)
                .show();

        limparCampos();
        finish();
    }

    private void limparCampos() {
        editTextNome.setText("");
        editTextDescricao.setText("");
    }

    public void cancelar(View v){
        finish();
    }

}