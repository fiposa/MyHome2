package Felix.MyHome.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Table
@Entity

public class Rekuperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    private String name;

    @OneToMany (mappedBy = "rekuperator",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List <Room> rooms;

    @OneToOne(mappedBy = "rekuperator")
    private House house;

    public Rekuperator() {
    }

    public Rekuperator(String name, List<Room> rooms, House house) {
        this.name = name;
        this.rooms = rooms;
        this.house = house;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Rekuperator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rooms=" + rooms +
                ", house=" + house.getName() +
                '}';
    }
}



