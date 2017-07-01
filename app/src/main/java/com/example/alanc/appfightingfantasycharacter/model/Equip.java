package com.example.alanc.appfightingfantasycharacter.model;

import java.io.Serializable;

/**
 * Created by alanc on 26/05/2017.
 */

public class Equip implements Serializable {

    private String id;
    private String nome;
    private String descricao;

    public Equip() {
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(String id) { this.id = id; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
