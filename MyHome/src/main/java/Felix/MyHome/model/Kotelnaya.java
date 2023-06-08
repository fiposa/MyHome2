package Felix.MyHome.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Kotelnaya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;


    @OneToOne (mappedBy = "kotelnaya")
    private House house;
/*
    private int kotelRatio;

    private boolean isBoilerStatusOn;
    private boolean isHeaterStatusOn;
    private boolean isKotelStatusOn;

    private boolean isManualHeaterOn;
    private boolean isManualBoilerOn;
    private boolean isManualKotelOn;

    private int tempIn;
    private int tempOut;
    private int tempAtHome;

    private int heaterHysteresis;
    private int minHeaterTemperature;
    private int maxHeaterTemperature;


    private int boilerOnDuration;*/

    public Kotelnaya() {
    }

    public Kotelnaya(String name, House house) {
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
        return "Kotelnaya{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", house=" + house.getName() +
                '}';
    }
}
