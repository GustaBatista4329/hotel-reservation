package br.com.gustavo.reservaSalas.models.services;

import br.com.gustavo.reservaSalas.models.dto.RoomDto;
import br.com.gustavo.reservaSalas.models.models.Room;
import br.com.gustavo.reservaSalas.models.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<RoomDto> showAllRooms() {
        return convertData(roomRepository.findAll());
    }

    public List<RoomDto> showAvaibleRooms() {
        return convertData(roomRepository.findAvailableRooms());
    }

    private List<RoomDto> convertData(List<Room> rooms){
        return rooms.stream()
                .map(r -> new RoomDto(r.getNumber(), r.getStatus()))
                .collect(Collectors.toList());
    }

}
