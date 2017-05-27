package com.example.alanc.appfightingfantasycharacter.dao.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alanc.appfightingfantasycharacter.dao.EquipDao;
import com.example.alanc.appfightingfantasycharacter.model.Equip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alanc on 26/05/2017.
 */

public class EquipDaoBd implements EquipDao {
    private BancoDadosOpenHelper bdOpenHelper;

    public EquipDaoBd(Context contexto){
        bdOpenHelper = new BancoDadosOpenHelper(contexto);
    }

    @Override
    public void inserir(Equip equip) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome",equip.getNome());
        valores.put("descricao",equip.getDescricao());
        banco.insert("equip",null,valores);

        banco.close();

    }

    @Override
    public void excluir(Equip equip) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();
        banco.delete("equip","id=?",
                new String[]{String.valueOf(equip.getId())});
        banco.close();
    }

    @Override
    public void atualizar(Equip equip) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome",equip.getNome());
        valores.put("descricao",equip.getDescricao());

        banco.update("equip",valores,"id=?",
                new String[]{String.valueOf(equip.getId())});
        banco.close();
    }

    @Override
    public List<Equip> listar() {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("equip",
                new String[]{"id","nome","descricao"},
                null,null,null,null,"nome");

        List<Equip> listaEquip = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            Equip equip = new Equip(id, nome, descricao);
            listaEquip.add(equip);
        }
        return listaEquip;
    }

    @Override
    public Equip procurarPorId(int id) {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("equip",
                new String[]{"id","nome","descricao"},
                "id = ?",new String[]{String.valueOf(id)},
                null,null,null);

        if(cursor.moveToNext()){
            int idX = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            Equip equip = new Equip(idX, nome, descricao);
            return equip;
        }
        return null;
    }
}