package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public ArrayList<String> getCpfComputado() {
    return cpfComputado;
  }

  public int getTotalVotos() {
    return totalVotos;
  }

  /**
   * Cadastra um novo candidato.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas.size() != 0) {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        if (candidato.numero == numero) {
          System.out.println("Número pessoa candidata já utilizado!");
          return;
        }
      }
    }

    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novoCandidato);

  }

  /**
   * Cadastra um novo eleitor.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.size() != 0) {
      for (PessoaEleitora eleitor : pessoasEleitoras) {
        if (eleitor.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
      }
    }

    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novoEleitor);

  }

  /**
   * Realiza um voto em um candidato.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    System.out.println(this.totalVotos);
    if (cpfComputado.size() != 0) {
      for (String cpf : cpfComputado) {
        if (cpfPessoaEleitora.equals(cpf)) {
          System.out.println("Pessoa eleitora já votou!");
          return;
        }
      }
    }

    if (pessoasCandidatas.size() != 0) {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        if (candidato.getNumero() == numeroPessoaCandidata) {
          candidato.receberVoto();
          cpfComputado.add(cpfPessoaEleitora);
          this.totalVotos += 1;
        }
      }
    }

  }

  /**
   * Mostra os resultados atuais da votacao.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      System.out.println("Nome: " + candidato.getNome() + " - " + candidato.getVotos() + " votos ( "
          + calcularPorcentagemVotos(pessoasCandidatas.indexOf(candidato)) + "% )");
    }

    System.out.println("Total de votos: " + this.totalVotos);

  }

  private double calcularPorcentagemVotos(int index) {
    PessoaCandidata candidato = pessoasCandidatas.get(index);
    double votosCandidato = candidato.getVotos();

    return Math.round((double) (votosCandidato / this.totalVotos) * 100);
  }
}


