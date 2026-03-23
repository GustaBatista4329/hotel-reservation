package br.com.gustavo.reservaSalas.models.dto;

import br.com.gustavo.reservaSalas.models.models.Reserve;

import java.util.List;

public record UserDto(String name,
                      String age,
                      String email,
                      String phone,
                      List<Reserve> reserve) {
}
