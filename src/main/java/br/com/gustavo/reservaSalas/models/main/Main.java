package br.com.gustavo.reservaSalas.models.main;

import br.com.gustavo.reservaSalas.models.models.Reserve;
import br.com.gustavo.reservaSalas.models.models.Room;
import br.com.gustavo.reservaSalas.models.models.SalaStatus;
import br.com.gustavo.reservaSalas.models.models.User;
import br.com.gustavo.reservaSalas.models.repositories.ReserveRepository;
import br.com.gustavo.reservaSalas.models.repositories.RoomRepository;
import br.com.gustavo.reservaSalas.models.repositories.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReserveRepository reserveRepository;

    public Main(UserRepository userRepository, RoomRepository roomRepository, ReserveRepository reserveRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.reserveRepository = reserveRepository;
    }

    public void showMenu() {
        int opc = -1;
        var menu = """
                ======= MENU HOTEL =======
                1 - Adicionar quarto
                2 - Adicionar hospede
                3 - Fazer reserva
                4 - Ver reservas do hospede
                
                0 - Sair do programa
                """;
        while (opc != 0) {
            System.out.println(menu);
            System.out.println("Escolha uma opção: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    addRoom();
                    break;

                case 2:
                    addUser();
                    break;

                case 3:
                    addReserve();
                    break;

                case 4:
                    showUserReserves();
                    break;
            }
        }
    }

    private void addRoom() {
        System.out.println("======= Adicionando quarto =======");
        System.out.println("Digite o numero do novo quarto");
        int roomNumber = scanner.nextInt();
        Room room = new Room(roomNumber, SalaStatus.DISPONIVEL);

        roomRepository.save(room);
    }

    private void addUser() {
        System.out.println("======= Adicionando usuário =======");
        System.out.println("Digite o nome do usuário");
        var userName = scanner.nextLine();
        System.out.println("Digite o CPF do usuário");
        var userCpf = scanner.next();
        if (userCpf.length() != 11) {
            System.out.println("CPF inválido");
        } else {
            System.out.println("Digite a idade do usuário");
            var userAge = scanner.next();
            System.out.println("Digite o email do usuário");
            var userEmail = scanner.next();
            System.out.println("Digite o telefone do usuário");
            var userPhone = scanner.next();

            User user = new User(userName, userCpf, userAge, userEmail, userPhone);

            userRepository.save(user);
        }
    }

    private void addReserve() {
        var reserve = new Reserve();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("======= Adicionando Reserva =======");
        System.out.println("O usuario já possui cadastro? (s/n)");
        var hasRegistration = scanner.nextLine();
        if (hasRegistration.equalsIgnoreCase("n")) {
            addUser();
            System.out.println("======= Termine a reserva =======");
        }
        System.out.println("Digite o cpf do cliente: ");
        var userCpf = scanner.next();
        var findRegistration = userRepository.existsByCpf(userCpf);
        if (!findRegistration) {
            System.out.println("Usuário não encontrada");
        } else {
            var user = userRepository.findByCpf(userCpf);
            reserve.setUsuario(user);

            System.out.println("======= Quartos disponiveis para uso =======");
            List<Room> allRooms = roomRepository.findAll();
            allRooms.forEach(
                    r -> System.out.println("Quarto: " + r.getNumber() + " - " + "(" + r.getStatus() + ")")
            );

            System.out.println("Deseja filtrar apenas os disponiveis? (s/n)");
            var avaiableRoomsFilter = scanner.next();
            if (avaiableRoomsFilter.equalsIgnoreCase("s")) {
                List<Room> avaiableRooms = roomRepository.findAvailableRooms();
                avaiableRooms.forEach(
                        r -> System.out.println("Quarto: " + r.getNumber() + " - " + "(" + r.getStatus() + ")")
                );
            }

            System.out.println("Escolha no número do quarto: ");
            var roomNumber = scanner.nextInt();
            scanner.nextLine();
            var selectedRoom = roomRepository.findByNumber(roomNumber);
            if (selectedRoom.getStatus().equals(SalaStatus.RESERVADO) || selectedRoom.getStatus().equals(SalaStatus.INATIVO)) {
                System.out.println("Selecione um quarto disponivel!!!");
            } else {
                reserve.setRoom(selectedRoom);
                System.out.println("Selecione a data de entrada");
                var entryDate = scanner.nextLine();
                try {
                    LocalDate localEntryDate = LocalDate.parse(entryDate, formatter);

                    System.out.println("Data lida com sucesso: " + localEntryDate);
                    System.out.println("Ano: " + localEntryDate.getYear());

                    reserve.setEntryDate(localEntryDate);
                } catch (DateTimeParseException e) {
                    System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy.");
                }
                System.out.println("O hospede sabe a data de saída? (s/n)");
                var hasDepartureDate = scanner.nextLine();
                if (hasDepartureDate.equalsIgnoreCase("s")) {
                    System.out.println("Selecione a data de saida");
                    var departureDate = scanner.nextLine();
                    try {
                        LocalDate localDepartureDate = LocalDate.parse(departureDate, formatter);

                        System.out.println("Data lida com sucesso: " + localDepartureDate);
                        System.out.println("Ano: " + localDepartureDate.getYear());

                        reserve.setDepartureDate(localDepartureDate);
                    } catch (RuntimeException e) {
                        System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy.");
                    }

                    reserveRepository.save(reserve);
                    roomRepository.changeStatus(selectedRoom.getId(), SalaStatus.RESERVADO);
                }
            }
        }
    }

    private void showUserReserves(){
        System.out.println("======= Buscando reservas do hospede =======");
        System.out.println("Digite o cpf do hospede");
        var userCpf = scanner.nextLine();
        var hasUserCpf = userRepository.existsByCpf(userCpf);
        if(hasUserCpf){
            var user = userRepository.findByCpf(userCpf);
            List<Reserve> reserveList = reserveRepository.findByUser(user);
            System.out.println("Reservas do " + user.getName());
            reserveList.forEach(
                    System.out::println
            );
        }
    }
}
