package br.com.zupedu.transacoes.kafka;


import br.com.zupedu.transacoes.TransacaoRepository;
import br.com.zupedu.transacoes.domain.Transacao;
import br.com.zupedu.transacoes.kafka.dto.TransacaoInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TopicListener {
    Logger log = LoggerFactory.getLogger(TopicListener.class);
    @Autowired
    private TransacaoRepository repository;

    @KafkaListener(topics = "${TOPICO_TRANSACOES}", containerFactory = "transacaoKafkaListenerContainerFactory")
    @Transactional
    public void listenTopicoTransacao(TransacaoInput input) {
        Transacao transacao = input.toModel();
        repository.save(transacao);
        log.info("Transação salva. Id: " + transacao.getId());
    }
}
