package br.com.zupedu.transacoes.kafka.dto;

import br.com.zupedu.transacoes.domain.Cartao;
import br.com.zupedu.transacoes.domain.Estabelecimento;
import br.com.zupedu.transacoes.domain.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class TransacaoInput {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoInput estabelecimento;
    private CartaoInput cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoInput() {
    }

    public Transacao toModel() {
        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        Cartao cartao = this.cartao.toModel();
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoInput getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoInput estabelecimentoInput) {
        this.estabelecimento = estabelecimentoInput;
    }

    public CartaoInput getCartao() {
        return cartao;
    }

    public void setCartao(CartaoInput cartaoInput) {
        this.cartao = cartaoInput;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TransacaoInput.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("valor=" + valor)
                .add("estabelecimento=" + estabelecimento)
                .add("cartao=" + cartao)
                .add("efetivadaEm=" + efetivadaEm)
                .toString();
    }
}
