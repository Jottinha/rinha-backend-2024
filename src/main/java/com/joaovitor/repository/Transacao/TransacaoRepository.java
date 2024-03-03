package com.joaovitor.repository.Transacao;

import com.joaovitor.domain.transacoes.Transacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    @Query("SELECT t FROM Transacao t WHERE t.idCliente = :id")
    List<Transacao> findHistoryTotalByIdCliente(@Param ("id") long id);
}
