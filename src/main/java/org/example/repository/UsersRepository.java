package org.example.repository;

import java.util.Optional;
import org.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

    public Optional<Users> findByUsuario(String usuario);
}
