package br.com.gustavo.reservaSalas.models.services;

import br.com.gustavo.reservaSalas.models.models.Reserve;
import br.com.gustavo.reservaSalas.models.models.Room;
import br.com.gustavo.reservaSalas.models.models.SalaStatus;
import br.com.gustavo.reservaSalas.models.repositories.ReserveRepository;
import br.com.gustavo.reservaSalas.models.repositories.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservationScheduler {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReserveRepository reserveRepository;

    @Scheduled(fixedDelay = 1 , timeUnit = TimeUnit.MINUTES)
    @Transactional
    public void releaseRoomsWithClosedReservations(){
        LocalDate today = LocalDate.now();
        List<Reserve> closedReservations = reserveRepository
                .findByDepartureDateBefore(today.plusDays(1));

        for(Reserve reserve : closedReservations){
            Room room = reserve.getRoom();

            room.setStatus(SalaStatus.DISPONIVEL);

            roomRepository.save(room);
        }
    }
}
