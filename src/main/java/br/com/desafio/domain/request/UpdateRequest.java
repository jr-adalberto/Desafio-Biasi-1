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
public class UpdateRequest {

    @NotBlank(message = "Campo requerido")
    private String nome;
    @NotNull(message = "Campo requerido")
    private Long idade;
    @NotBlank(message = "Campo requerido")
    private String bairro;
    @NotBlank(message = "Campo requerido")
    private String cidade;
    @NotBlank(message = "Campo requerido")
    private String rua;
    @NotBlank(message = "Campo requerido")
    private String complemento;
}
