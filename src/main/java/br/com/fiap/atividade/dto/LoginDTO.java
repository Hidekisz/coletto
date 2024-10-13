package br.com.fiap.atividade.dto;

import jakarta.validation.constraints.*;

public record LoginDTO(
        @NotBlank(message = "O email do usuário é obrigatório")
        @Email(message = "O email não é válido")
        String email,
        @NotBlank(message="A senha do usuário é obrigatória")
        @Size(min=6,max=20, message="A senha deve conter entre 6 e 20 caracteres!")
        String senha
) {
}
