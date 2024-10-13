package br.com.fiap.atividade.service;

import br.com.fiap.atividade.dto.request.UserRequest;
import br.com.fiap.atividade.dto.response.UserResponse;
import br.com.fiap.atividade.entity.UserEntity;
import br.com.fiap.atividade.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse salvarUsuario (UserRequest userRequest){
        String senhaCriptografada = new BCryptPasswordEncoder().encode(userRequest.senha());

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest,userEntity);
        userEntity.setSenha(senhaCriptografada);
        UserEntity usuarioSalvo = userRepository.save(userEntity);
        return new UserResponse(usuarioSalvo);
    }
}
