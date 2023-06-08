package Felix.MyHome.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "house")
@Component
public class House {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    @NotBlank
    private String name;



    @ManyToOne
    private User user;


    @Column (name = "address")

    private String address;

    @OneToOne (cascade = CascadeType.MERGE)//Если ставить ALL, то ошибка при создании взаимосвязанных сущностей
    @JoinColumn (name = "rekuperator_id", referencedColumnName = "id")
    private Rekuperator rekuperator;

    @OneToMany (mappedBy = "house", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List <Gate> gates;

    @OneToOne (cascade= CascadeType.MERGE)
    @JoinColumn (name = "kotelnaya_id", referencedColumnName = "id")
    private Kotelnaya kotelnaya;

    public House() {
    }

    public House(String name, User user, String address, Rekuperator rekuperator, List<Gate> gates, Kotelnaya kotelnaya) {
        this.name = name;
        this.user = user;
        this.address = address;
        this.rekuperator = rekuperator;
        this.gates = gates;
        this.kotelnaya = kotelnaya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Rekuperator getRecuperator() {
        return rekuperator;
    }

    public void setRecuperator(Rekuperator rekuperator) {
        this.rekuperator = rekuperator;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public Rekuperator getRekuperator() {
        return rekuperator;
    }

    public void setRekuperator(Rekuperator rekuperator) {
        this.rekuperator = rekuperator;
    }

    public Kotelnaya getKotelnaya() {
        return kotelnaya;
    }

    public void setKotelnaya(Kotelnaya kotelnaya) {
        this.kotelnaya = kotelnaya;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", rekuperator=" + rekuperator +
                ", gates=" + gates +
                ", kotelnaya=" + kotelnaya +
                '}';
    }
}
