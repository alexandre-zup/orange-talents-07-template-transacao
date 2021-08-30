package br.com.zupedu.transacoes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Embeddable
public class Cartao {
    @NotBlank
    @Column(name = "cartao_id", nullable = false)
    private String id;

    @NotBlank
    @Column(name = "cartao_email", nullable = false)
    private String email;

    /**
     * @deprecated exclusivo para frameworks
     */
    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cartao.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
