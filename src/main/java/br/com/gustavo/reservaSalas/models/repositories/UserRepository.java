package br.com.gustavo.reservaSalas.models.repositories;

import br.com.gustavo.reservaSalas.models.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCpf(String cpf);
    User findByCpf(String cpf);
}
