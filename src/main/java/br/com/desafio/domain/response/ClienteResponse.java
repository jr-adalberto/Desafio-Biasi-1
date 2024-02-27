package br.com.desafio.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String cnpjCpf;
    private Long idade;
    private String bairro;
    private String cidade;
    private String rua;
    private String complemento;
}
