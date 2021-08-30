package br.com.zupedu.transacoes;

import br.com.zupedu.transacoes.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String cartaoId);
}
