package com.joaovitor.controller;

import com.joaovitor.domain.transacoes.TransacaoDTO;
import com.joaovitor.domain.transacoes.TransacaoRetorno;
import com.joaovitor.services.TransacoesService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransacoesController {
    private TransacoesService service;

    public TransacoesController(TransacoesService service) {
        this.service = service;
    }

    @Path("/{id}/transacoes")
    @POST
    @Transactional
    public Response insertTransacoes(@PathParam("id") Integer id, TransacaoDTO transacao){
        TransacaoRetorno retorno = service.insertTransacoes(transacao, id);
        return Response.ok(retorno).build();
    }

    //TODO: Os retornos caso seja usado Debito ou Credito
}
