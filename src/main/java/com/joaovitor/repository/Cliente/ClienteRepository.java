package com.joaovitor.repository.Cliente;

import com.joaovitor.domain.Clientes.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
