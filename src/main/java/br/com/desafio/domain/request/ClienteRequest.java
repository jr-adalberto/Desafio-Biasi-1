package br.com.desafio.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "Obrigatório inserir o nome")
    private String nome;
    @NotBlank(message = "Obrigatório inserir o cnpj/cpf")
    private String cnpjCpf;
    @NotNull(message = "Obrigatório inserir a idade")
    private Long idade;
    @NotBlank(message = "Obrigatório inserir o sexo")
    private String sexo;
    @NotBlank(message = "Obrigatório inserir bairro")
    private String bairro;
    @NotBlank(message = "Obrigatório inserir cidade")
    private String cidade;
    @NotBlank(message = "Obrigatório inserir rua")
    private String rua;
    private String complemento;

}
