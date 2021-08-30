package br.com.zupedu.transacoes.kafka.dto;

import br.com.zupedu.transacoes.domain.Cartao;

import java.util.StringJoiner;

public class CartaoInput {
    private String id;
    private String email;

    public CartaoInput() {
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoInput.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
