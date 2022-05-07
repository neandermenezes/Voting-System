package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);
    short chosenOption = 1;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      chosenOption = scan.nextShort();

      if (chosenOption == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();

        votacao.cadastrarPessoaCandidata(nome, numero);
      }
    } while (chosenOption == 1);

    chosenOption = 1;

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      chosenOption = scan.nextShort();

      if (chosenOption == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scan.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        votacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (chosenOption == 1);

    chosenOption = 1;

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      chosenOption = scan.nextShort();

      if (chosenOption == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scan.nextInt();

        votacao.votar(cpf, numeroCandidato);
      } else if (chosenOption == 2) {
        votacao.mostrarResultado();
      } else {
        votacao.mostrarResultado();
      }
    } while (chosenOption == 1 || chosenOption == 2);

    scan.close();

  }

}
