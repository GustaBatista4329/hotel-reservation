package br.com.gustavo.reservaSalas.models.services;

import br.com.gustavo.reservaSalas.models.dto.UserDto;
import br.com.gustavo.reservaSalas.models.models.User;
import br.com.gustavo.reservaSalas.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDto> showAllUsers() {
        return converData(userRepository.findAll());
    }


    private List<UserDto> converData(List<User> users){
        return users.stream()
                .map(u -> new UserDto(u.getName(), u.getAge(), u.getEmail(), u.getPhone(), u.getReserves()))
                .collect(Collectors.toList());
    }
}
