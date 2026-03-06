package br.com.gustavo.reservaSalas.models.controller;

import br.com.gustavo.reservaSalas.models.dto.UserDto;
import br.com.gustavo.reservaSalas.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDto> showAllUsers(){
        return userService.showAllUsers();
    }
}
