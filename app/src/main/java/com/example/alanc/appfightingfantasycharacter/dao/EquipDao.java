package com.example.alanc.appfightingfantasycharacter.dao;

import com.example.alanc.appfightingfantasycharacter.model.Equip;
import java.util.List;

/**
 * Created by alanc on 26/05/2017.
 */

public interface EquipDao {
    public void inserir(Equip equip);
    public void excluir(Equip equip);
    public void atualizar(Equip equip);
    public List<Equip> listar();
    public Equip procurarPorId(int id);

}