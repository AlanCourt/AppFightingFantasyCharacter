package com.example.alanc.appfightingfantasycharacter.model;

import java.io.Serializable;

/**
 * Created by iossenac on 27/05/17.
 */

public class FichaDados implements Serializable {
    private int id;
    private int habilidade;
    private int energia;
    private int sorte;
    private int ouro;
    private int joias;
    private int provisoes;
    private String pagina;

    public FichaDados(int habilidade, int energia, int sorte, int ouro, int joias, int provisoes, String pagina) {
        this.habilidade = habilidade;
        this.energia = energia;
        this.sorte = sorte;
        this.ouro = ouro;
        this.joias = joias;
        this.provisoes = provisoes;
        this.pagina = pagina;
    }

    public FichaDados(int id, int habilidade, int energia, int sorte, int ouro, int joias, int provisoes, String pagina) {
        this.id = id;
        this.habilidade = habilidade;
        this.energia = energia;
        this.sorte = sorte;
        this.ouro = ouro;
        this.joias = joias;
        this.provisoes = provisoes;
        this.pagina = pagina;
    }

    public int getId() {
        return id;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSorte() {
        return sorte;
    }

    public int getOuro() {
        return ouro;
    }

    public int getJoias() {
        return joias;
    }

    public int getProvisoes() {
        return provisoes;
    }

    public String getPagina() {
        return pagina;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setJoias(int joias) {
        this.joias = joias;
    }

    public void setProvisoes(int provisoes) {
        this.provisoes = provisoes;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}