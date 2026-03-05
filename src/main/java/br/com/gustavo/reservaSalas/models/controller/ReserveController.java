package br.com.gustavo.reservaSalas.models.controller;

import br.com.gustavo.reservaSalas.models.dto.ReserveDto;
import br.com.gustavo.reservaSalas.models.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    @GetMapping(value = "/reserves")
    public List<ReserveDto> showAllReserves(){
        return reserveService.showAllReserves();
    }
}
