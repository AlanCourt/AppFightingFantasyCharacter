package com.example.alanc.appfightingfantasycharacter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alanc.appfightingfantasycharacter.model.Equip;

public class DetalheItem extends AppCompatActivity {

    EditText editTextNome, editTextDescricao;
    Equip equipEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_item);

        Intent it = getIntent();
        this.equipEditar = (Equip) it.getSerializableExtra("equip");

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextDescricao = (EditText) findViewById(R.id.editTextDescricao);
        editTextNome.setText(equipEditar.getNome());
        editTextDescricao.setText(equipEditar.getDescricao());
    }


    public void editar(View v){

        Equip e = new Equip();
        e.setId(equipEditar.getId());
        e.setNome(editTextNome.getText().toString().trim());
        e.setDescricao(editTextDescricao.getText().toString().trim());

        ControlLifeCycleAllApp.myRef.child("Equip").child(e.getId()).setValue(e);
        limparCampos();

        Toast.makeText(this,"Edição realizada com sucesso!", Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void excluir(View v){

        Equip e = new Equip();
        e.setId(equipEditar.getId());
        ControlLifeCycleAllApp.myRef.child("Equip").child(e.getId()).removeValue();
        limparCampos();

        Toast.makeText(this,"Exclusão realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void cancelar(View v){
        finish();
    }

    private void limparCampos() {
        editTextNome.setText("");
        editTextDescricao.setText("");
    }
}
