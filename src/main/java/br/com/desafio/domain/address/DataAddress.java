package br.com.desafio.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(@NotBlank String city,
                          @NotBlank String street,
                          @NotBlank String neighborhood,
                          @NotBlank Double number,
                          @NotBlank @Pattern(regexp = "\\d{8}")String code,
                          String complement) {

}
