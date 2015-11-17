package com.example.a15alejandroog.ud_a1a_a15alejandroog;

/**
 * Created by a15alejandroog on 11/17/15.
 */
public class Persoa {
    private String nome;
    private String descricion;

    public Persoa(String nome, String descricion) {
        this.nome = nome;
        this.descricion = descricion;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public String toString() {
        return nome + "\n" + descricion;
    }
}
