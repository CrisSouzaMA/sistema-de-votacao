package main.sistemavotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfComputado = new ArrayList<>();
  private int totalVotos = 0;

  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean ehCadastrado = false;
    for (PessoaCandidata novoCandidato : this.pessoasCandidatas) {
      if (novoCandidato.getNumero() == numero) {
        ehCadastrado = true;
        break;
      }
    }

    if (ehCadastrado) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novoCandidato);
    }
  }
}
