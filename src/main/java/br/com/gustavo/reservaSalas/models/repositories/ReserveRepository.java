package br.com.gustavo.reservaSalas.models.repositories;

import br.com.gustavo.reservaSalas.models.models.Reserve;
import br.com.gustavo.reservaSalas.models.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUser(User user);
    List<Reserve> findByUserCpf(String cpf);

    List<Reserve> findByDepartureDateBefore(LocalDate localDate);
}
