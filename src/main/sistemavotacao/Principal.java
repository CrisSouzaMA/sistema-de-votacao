package main.sistemavotacao;

import java.util.Scanner;
public class Principal {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    int opcaoCandidato = 0;
    int opcaoEleitor = 0;
    int opcaoSelecionadaVoto = 0;

    do {
      // menu de cadastro pessoas candidatas
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - sim");
      System.out.println("2 - não");
      System.out.println("Entre com o número correspondente à opção desejada: ");
      opcaoCandidato = scan.nextInt();
      if (opcaoCandidato == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        String nome = scan.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        int numeroVotacao = scan.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numeroVotacao);
      }
    } while (opcaoCandidato == 1);


    do {
      // cadastro de pessoas eleitoras
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - sim");
      System.out.println("2 - não");
      System.out.println("Entre com o número correspondente à opção desejada: ");
      opcaoEleitor = scan.nextInt();
      if (opcaoEleitor == 1) {
        System.out.println("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String numeroCpf = scan.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, numeroCpf);
      }
    } while (opcaoEleitor == 1);

    do {
      System.out.println("Entre com o número correspondente à opção desejada: ");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcaoSelecionada = scan.nextInt();
      opcaoSelecionadaVoto = opcaoSelecionada;

      if (opcaoSelecionada == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        String cpfEleitor = scan.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        int numeroCandidato = scan.nextInt();
        gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
      } else if (opcaoSelecionada == 2) {
        gerenciamentoVotacao.mostrarResultado();
        System.out.println("Entre com o número correspondente à opção desejada: ");
        System.out.println("1 - Votar");
        System.out.println("2 - Resultado Parcial");
        System.out.println("3 - Finalizar Votação");
      } else {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (opcaoSelecionadaVoto == 1);
  }
}
