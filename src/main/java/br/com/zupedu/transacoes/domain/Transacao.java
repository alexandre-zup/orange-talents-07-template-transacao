package br.com.zupedu.transacoes.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
public class Transacao {
    @Id
    private String id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull
    @Embedded
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @CreationTimestamp
    private LocalDateTime inseridaEm;

    /**
     * @deprecated exclusivo para frameworks
     */
    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Transacao.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("valor=" + valor)
                .add("estabelecimento=" + estabelecimento)
                .add("cartao=" + cartao)
                .add("efetivadaEm=" + efetivadaEm)
                .add("inseridaEm=" + inseridaEm)
                .toString();
    }
}
