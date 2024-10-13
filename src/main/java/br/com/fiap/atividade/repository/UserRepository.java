package br.com.fiap.atividade.repository;

import br.com.fiap.atividade.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    UserDetails findByEmail(String email);
}
