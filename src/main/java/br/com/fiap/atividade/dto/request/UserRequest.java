package br.com.fiap.atividade.dto.request;

import br.com.fiap.atividade.enums.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        String usuarioId,

        @NotBlank (message="O nome de usuário é obrigatório!")
        String nome,

        @NotBlank (message="O email é obrigatório!")
        @Email (message="O email do usuário não é válido!")
        String email,

        @NotBlank
        @Size(min=6,max=20, message=" A senha deve conter entre 6 e 20 caracteres")
        String senha,

        UserRoleEnum role
) {
}
