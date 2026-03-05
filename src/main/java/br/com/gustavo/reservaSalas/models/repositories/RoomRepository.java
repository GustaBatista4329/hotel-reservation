package br.com.gustavo.reservaSalas.models.repositories;

import br.com.gustavo.reservaSalas.models.models.Room;
import br.com.gustavo.reservaSalas.models.models.SalaStatus;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByNumber(int roomNumber);

    @Query(value = "SELECT * FROM rooms r WHERE r.status = 'DISPONIVEL'", nativeQuery = true)
    List<Room> findAvailableRooms();

    @Transactional
    @Modifying
    @Query("UPDATE Room r SET r.status = :status WHERE r.id = :id")
    void changeStatus(@Param("id") Long id, @Param("status") SalaStatus status);
}
