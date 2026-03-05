package br.com.gustavo.reservaSalas.models.dto;

import br.com.gustavo.reservaSalas.models.models.Room;
import br.com.gustavo.reservaSalas.models.models.User;

import java.time.LocalDate;

public record ReserveDto(String userName,
                         String cpf,
                         int roomNumber,
                         LocalDate entryDate,
                         LocalDate departureDate
) { }
