package br.com.fiap.atividade.dto.response;

import br.com.fiap.atividade.entity.UserEntity;
import br.com.fiap.atividade.enums.UserRoleEnum;
import lombok.Builder;

@Builder
public record UserResponse (

        String usuarioId,
        String nome,
        String email,
        UserRoleEnum role

){
    public UserResponse(UserEntity user){
        this( user.getUserId(),
                user.getNome(),
                user.getEmail(),
                user.getRole());
    }
}
