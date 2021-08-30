package br.com.zupedu.transacoes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Embeddable
public class Estabelecimento {
    @NotBlank
    @Column(name = "est_nome", nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "est_cidade", nullable = false)
    private String cidade;

    @NotBlank
    @Column(name = "est_endereco", nullable = false)
    private String endereco;

    /**
     * @deprecated exclusivo para frameworks
     */
    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Estabelecimento.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("cidade='" + cidade + "'")
                .add("endereco='" + endereco + "'")
                .toString();
    }
}
