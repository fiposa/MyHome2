package Felix.MyHome.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Table
@Entity

public class Rekuperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    private String name;

    @OneToOne(mappedBy = "rekuperator")
    private House house;

    public Rekuperator() {
    }

    public Rekuperator(String name, House house) {
        this.name = name;
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
                ", house=" + house.getName() +
                '}';
    }
}



