package br.com.gustavo.reservaSalas.models;

import br.com.gustavo.reservaSalas.models.main.Main;
import br.com.gustavo.reservaSalas.models.repositories.ReserveRepository;
import br.com.gustavo.reservaSalas.models.repositories.RoomRepository;
import br.com.gustavo.reservaSalas.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class RoomReserveApplication{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReserveRepository reserveRepository;

	public static void main(String[] args) {
		SpringApplication.run(RoomReserveApplication.class, args);
	}
}
