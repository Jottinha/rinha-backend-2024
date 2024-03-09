package com.joaovitor.controller;

import com.joaovitor.domain.extrato.ExtratoRetorno;
import com.joaovitor.services.ExtratoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExtratoController {

    private ExtratoService service;

    public ExtratoController(ExtratoService service) {
        this.service = service;
    }

    @Path("/{id}/extrato")
    @GET
    public Response getExtrato(@PathParam("id") Integer id){
        ExtratoRetorno retorno = service.getExtrato(id);
        return Response.ok(retorno).build();
    }
}
