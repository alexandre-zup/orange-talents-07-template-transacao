package br.com.zupedu.transacoes.kafka.dto;

import br.com.zupedu.transacoes.domain.Estabelecimento;

import java.util.StringJoiner;

public class EstabelecimentoInput {
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoInput() {
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EstabelecimentoInput.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("cidade='" + cidade + "'")
                .add("endereco='" + endereco + "'")
                .toString();
    }
}
