package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  protected int numero;
  protected int votos;

  PessoaCandidata(String nome, int numero) {
    this.votos = 0;
    this.nome = nome;
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void receberVoto() {
    this.votos += 1;
  }


}
