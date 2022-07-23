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

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean ehEleitorCadastrado = false;
    for (PessoaEleitora novoEleitor : this.pessoasEleitoras) {
      if (novoEleitor.getCpf().equals(cpf)) {
        ehEleitorCadastrado = true;
        break;
      }
    }
    if (ehEleitorCadastrado) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novoEleitor);
    }
  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCand : this.pessoasCandidatas) {
        if (pessoaCand.getNumero() == numeroPessoaCandidata) {
          pessoaCand.receberVoto();
          this.cpfComputado.add(cpfPessoaEleitora);
          this.totalVotos += 1;
        }
      }
    }
  }

}
