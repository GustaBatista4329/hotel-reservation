package br.com.gustavo.reservaSalas.models.services;

import br.com.gustavo.reservaSalas.models.dto.ReserveDto;
import br.com.gustavo.reservaSalas.models.models.Reserve;
import br.com.gustavo.reservaSalas.models.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReserveService {
    @Autowired
    ReserveRepository reserveRepository;

    public List<ReserveDto> showAllReserves(){
        return convertData(reserveRepository.findAll());
    }

    private List<ReserveDto> convertData(List<Reserve> reserves){
        return reserves.stream()
                .map(r -> new ReserveDto(r.getUsuario().getName(), r.getUsuario().getCpf(), r.getRoom().getNumber(), r.getEntryDate(), r.getDepartureDate()))
                .collect(Collectors.toList());
    }
}
