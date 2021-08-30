package br.com.zupedu.transacoes;

import br.com.zupedu.transacoes.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
