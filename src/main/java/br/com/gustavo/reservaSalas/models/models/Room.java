package br.com.gustavo.reservaSalas.models.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "rooms",
        uniqueConstraints = @UniqueConstraint(name = "uk_number_room", columnNames = "numero")
)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int number;
    @Enumerated(EnumType.STRING)
    private SalaStatus status;
    @OneToMany
    private List<Reserve> reserves;

    public Room(int number, SalaStatus status) {
        this.number = number;
        this.status = status;
    }

    public Room(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SalaStatus getStatus() {
        return status;
    }

    public void setStatus(SalaStatus status) {
        this.status = status;
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }
}
