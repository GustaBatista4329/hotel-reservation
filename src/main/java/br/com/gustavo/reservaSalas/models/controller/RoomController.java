package br.com.gustavo.reservaSalas.models.controller;

import br.com.gustavo.reservaSalas.models.dto.RoomDto;
import br.com.gustavo.reservaSalas.models.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDto> showAllRooms(){
        return roomService.showAllRooms();
    }

    @GetMapping("/rooms/avaiable")
    public List<RoomDto> showAvaibleRooms(){
        return roomService.showAvaibleRooms();
    }
}
