package com.example.alanc.appfightingfantasycharacter.dao;

import com.example.alanc.appfightingfantasycharacter.model.FichaDados;

/**
 * Created by iossenac on 27/05/17.
 */

public interface FichaDadosDao {
    public void inserir(FichaDados fichaDados);
    public void atualizar(FichaDados fichaDados);
    public FichaDados procurarPorId(int id);
}
