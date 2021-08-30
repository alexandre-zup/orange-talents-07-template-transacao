package br.com.zupedu.transacoes.resource;

import br.com.zupedu.transacoes.TransacaoRepository;
import br.com.zupedu.transacoes.domain.Transacao;
import br.com.zupedu.transacoes.resource.dto.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransacaoController {
    @Autowired
    private TransacaoRepository repository;

    @GetMapping("/api/cartoes/{id}/transacoes")
    public ResponseEntity<List<TransacaoResponse>> buscaUltimasDezTransacoes(@PathVariable String id) {
        List<Transacao> transacoes = repository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);

        if(transacoes.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList()));
    }
}
