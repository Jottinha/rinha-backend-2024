package com.joaovitor.repository.Transacao;

import com.joaovitor.domain.transacoes.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
