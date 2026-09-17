package com.auragestao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(
            regexp = "\\d{10,11}",
            message = "O telefone deve conter 10 ou 11 dígitos"
    )
    private String phone;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(
            regexp = "\\d{11}",
            message = "O CPF deve conter 11 dígitos"
    )
    private String cpf;

    @NotNull(message = "O tipo de usuário é obrigatório")
    private Integer typeUser;
}