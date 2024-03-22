package com.joaovitor.services;

import com.joaovitor.domain.Clientes.Cliente;
import com.joaovitor.repository.Cliente.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClientesService {
    @Inject
    private ClienteRepository clientes;

    public boolean clienteExiste(long idCliente){
        Cliente clienteBuscado = clientes.findById(idCliente).orElse(null);
        return clienteBuscado != null;
    }
    public int buscaLimite(long idCliente){
        Cliente clienteBuscado = clientes.findById(idCliente).orElse(null);
        return clienteBuscado.getLimite();
    }

    public void atualizaLimite(long idCliente, int novoLimite){
        Cliente clienteBuscado = clientes.findById(idCliente).orElse(null);
        clienteBuscado.setLimite(novoLimite);
        clientes.save(clienteBuscado);
    }
}
