package br.com.fiap.atividade.config.security;

import br.com.fiap.atividade.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${secure.key}")
    private String palavraSecreta;

    public String gerarToken(UserEntity userEntity){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            String token = JWT
                    .create()
                    .withIssuer("coleta")
                    .withSubject(userEntity.getEmail())
                    .withExpiresAt(gerarDataExpiração())
                    .sign(algorithm);
            return token;

        }   catch(JWTCreationException jwt){
            throw new RuntimeException("Não foi possível gerar o token !");
        }
    }

    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            return JWT.require(algorithm)
                    .withIssuer("coleta")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException jwtVerificationException){
            return "";
        }
    }

    public Instant gerarDataExpiração (){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
