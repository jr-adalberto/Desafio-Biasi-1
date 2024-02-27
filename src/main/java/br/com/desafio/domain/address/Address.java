package br.com.desafio.domain.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String neighborhood;
    private String complement;
    private Double number;
    private String code;
}
