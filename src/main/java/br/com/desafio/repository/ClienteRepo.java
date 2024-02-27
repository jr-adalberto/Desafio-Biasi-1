package br.com.desafio.repository;

import br.com.desafio.domain.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepo extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByCnpjCpf(String cnpjCpf);


}
