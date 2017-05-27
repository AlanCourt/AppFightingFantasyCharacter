package com.example.alanc.appfightingfantasycharacter.dao.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alanc on 26/05/2017.
 */

public class BancoDadosOpenHelper extends SQLiteOpenHelper {
    private static String nomeBD = "crudEquip.db";
    private static String createTable = "CREATE TABLE equip" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome VARCHAR(30)," +
            "descricao VARCHAR(20))";

    private static String createTable2 = "CREATE TABLE fichaDados" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "habilidade INTEGER," +
            "energia INTEGER," +
            "sorte INTEGER," +
            "ouro INTEGER," +
            "joias INTEGER," +
            "provisoes INTEGER," +
            "pagina VARCHAR(20))";

    public BancoDadosOpenHelper(Context context) {
        super(context, nomeBD, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
        db.execSQL(createTable2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE equip");
        db.execSQL("DROP TABLE fichaDados");
        db.execSQL(createTable);
        db.execSQL(createTable2);
    }
}