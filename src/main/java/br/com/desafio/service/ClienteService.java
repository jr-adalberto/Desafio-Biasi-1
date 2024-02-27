package br.com.desafio.service;

import br.com.desafio.domain.ApiException;
import br.com.desafio.domain.entity.ClienteEntity;
import br.com.desafio.domain.request.ClienteRequest;
import br.com.desafio.domain.request.UpdateRequest;
import br.com.desafio.domain.response.ClienteResponse;
import br.com.desafio.repository.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public ClienteResponse salvarCliente(ClienteRequest request) {
        //verificar se existe um cliente dom o Cnpj/cpf já cadastrado e apresenta msg para usuario caso seja true
        var cliente = clienteRepo.findByCnpjCpf(request.getCnpjCpf());
        if (cliente.isPresent())
            throw new ApiException("Cliente já cadastro no sistema, CNPJ: " + request.getCnpjCpf(), HttpStatus.BAD_REQUEST);

        var resultado = clienteRepo.save(convertToEntity(request));
        return convertToResponse(resultado);
    }


    public ClienteResponse atualizarCliente(Long id, UpdateRequest request) {
        var cliente = getClienteFindById(id);

        cliente.setNome(request.getNome());
        cliente.setIdade(request.getIdade());
        cliente.setBairro(request.getBairro());
        cliente.setCidade(request.getCidade());
        cliente.setRua(request.getRua());
        cliente.setComplemento(request.getComplemento());

        //Salva o cliente
        var clienteSalvo = clienteRepo.save(cliente);
        return convertToResponse(clienteSalvo);
    }

    public void deletarCliente(Long id) {
        var cliente = getClienteFindById(id);
        clienteRepo.deleteById(cliente.getId());
    }

    public List<ClienteResponse> findAll() {
        List<ClienteEntity> clientes = clienteRepo.findAll();
        if (clientes.isEmpty())
            throw new ApiException("Nenhum cliente cadastrado", HttpStatus.BAD_REQUEST);

        return convertToListResponse(clientes);
    }

    public ClienteResponse buscarClienteById(Long clienteId) {
        var cliente = getClienteFindById(clienteId);
        return this.convertToResponse(cliente);
    }

    private List<ClienteResponse> convertToListResponse(List<ClienteEntity> listaCliente) {
        if (listaCliente.isEmpty())
            return new ArrayList<>();

        List<ClienteResponse> listaResponse = new ArrayList<>();
        for (ClienteEntity cliente : listaCliente)
            listaResponse.add(convertToResponse(cliente));

        return listaResponse;
    }

    private ClienteResponse convertToResponse(ClienteEntity resultado) {
        return ClienteResponse.builder()
                .id(resultado.getId())
                .nome(resultado.getNome())
                .cnpjCpf(resultado.getCnpjCpf())
                .idade(resultado.getIdade())
                .bairro(resultado.getBairro())
                .cidade(resultado.getCidade())
                .rua(resultado.getRua())
                .complemento(resultado.getComplemento())
                .build();
    }

    private ClienteEntity convertToEntity(ClienteRequest request) {
        return ClienteEntity.builder()
                .nome(request.getNome())
                .cnpjCpf(request.getCnpjCpf())
                .idade(request.getIdade())
                .sexo(request.getSexo())
                .bairro(request.getBairro())
                .cidade(request.getCidade())
                .rua(request.getRua())
                .complemento(request.getComplemento())
                .build();
    }

    private ClienteEntity getClienteFindById(Long id) {
        return clienteRepo.findById(id)
                .orElseThrow(() -> new ApiException("Nenhum cliente cadastrado", HttpStatus.BAD_REQUEST));
    }
}
