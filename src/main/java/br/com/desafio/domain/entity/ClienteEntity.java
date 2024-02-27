package br.com.desafio.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cnpj_cpf")
    private String cnpjCpf;
    private String nome;
    private Long idade;
    private String sexo;
    private String bairro;
    private String cidade;
    private String rua;
    private String complemento;
}
