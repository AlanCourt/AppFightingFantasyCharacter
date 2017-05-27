package com.example.alanc.appfightingfantasycharacter.dao.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alanc.appfightingfantasycharacter.dao.FichaDadosDao;
import com.example.alanc.appfightingfantasycharacter.model.Equip;
import com.example.alanc.appfightingfantasycharacter.model.FichaDados;

/**
 * Created by iossenac on 27/05/17.
 */

public class FichaDadosDaoBd implements FichaDadosDao {

    private BancoDadosOpenHelper bdOpenHelper;

    public FichaDadosDaoBd(Context contexto){
        bdOpenHelper = new BancoDadosOpenHelper(contexto);
    }

    @Override
    public void inserir(FichaDados fichaDados) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("habilidade",fichaDados.getHabilidade());
        valores.put("energia",fichaDados.getEnergia());
        valores.put("sorte",fichaDados.getSorte());
        valores.put("ouro",fichaDados.getOuro());
        valores.put("joias",fichaDados.getJoias());
        valores.put("provisoes",fichaDados.getProvisoes());
        valores.put("pagina",fichaDados.getPagina());

        banco.insert("fichaDados",null,valores);

        banco.close();
    }

    @Override
    public void atualizar(FichaDados fichaDados) {

        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("habilidade",fichaDados.getHabilidade());
        valores.put("energia",fichaDados.getEnergia());
        valores.put("sorte",fichaDados.getSorte());
        valores.put("ouro",fichaDados.getOuro());
        valores.put("joias",fichaDados.getJoias());
        valores.put("provisoes",fichaDados.getProvisoes());
        valores.put("pagina",fichaDados.getPagina());

        banco.update("fichaDados",valores,"id=?",
                new String[]{String.valueOf(fichaDados.getId())});
        banco.close();
    }

    @Override
    public FichaDados procurarPorId(int id) {

        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("fichaDados",
                new String[]{"id","habilidade","energia","sorte","ouro","joias","provisoes","pagina"},
                "id = ?",new String[]{String.valueOf(id)},
                null,null,null);

        if(cursor.moveToNext()){
            int idX = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            FichaDados fichaDados = new FichaDados(idX, nome, descricao);
            return fichaDados;
        }
        return null;
    }
}