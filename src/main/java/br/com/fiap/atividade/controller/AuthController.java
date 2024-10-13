package br.com.fiap.atividade.controller;

import br.com.fiap.atividade.config.security.TokenService;
import br.com.fiap.atividade.dto.LoginDTO;
import br.com.fiap.atividade.dto.request.UserRequest;
import br.com.fiap.atividade.dto.response.TokenResponse;
import br.com.fiap.atividade.dto.response.UserResponse;
import br.com.fiap.atividade.entity.UserEntity;
import br.com.fiap.atividade.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.email(),
                        loginDTO.senha());
        Authentication auth = authenticationManager.authenticate(userNamePassword);

        String token = tokenService.gerarToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(token));
    }



    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody @Valid UserRequest userRequest){
        UserResponse usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(userRequest);

        return usuarioSalvo;
    }
}
