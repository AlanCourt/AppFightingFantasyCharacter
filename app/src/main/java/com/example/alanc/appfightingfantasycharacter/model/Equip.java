package com.example.alanc.appfightingfantasycharacter.model;

import java.io.Serializable;

/**
 * Created by alanc on 26/05/2017.
 */

public class Equip implements Serializable {
    private int id;
    private String nome;
    private String descricao;

    public Equip(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Equip(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
