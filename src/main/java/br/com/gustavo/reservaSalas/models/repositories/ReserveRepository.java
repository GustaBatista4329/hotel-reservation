package br.com.gustavo.reservaSalas.models.repositories;

import br.com.gustavo.reservaSalas.models.models.Reserve;
import br.com.gustavo.reservaSalas.models.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUser(User user);
}
