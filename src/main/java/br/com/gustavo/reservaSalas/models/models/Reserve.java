package br.com.gustavo.reservaSalas.models.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entryDate;
    private LocalDate departureDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Room room;

    public Reserve(User user, Room room, LocalDate entryDate, LocalDate departureDate) {
        this.user = user;
        if(room.getStatus() == SalaStatus.RESERVADO || room.getStatus() == SalaStatus.INATIVO){
            throw new IllegalArgumentException("Esse quarto não pode ser reservado, escolh outro por favor");
        } else{
            this.room = room;
        }
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }

    public Reserve(){}

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "Quarto = " + room.getNumber() +
                ", Data de entrada = " + entryDate +
                ", Data de saída = " + departureDate +
                '}';
    }
}
