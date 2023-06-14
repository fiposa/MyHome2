package Felix.MyHome.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table (name = "Gates")

public class Gate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column (name = "gate_open")
    private boolean gateOpen;

    @Column (name = "delay")
    @NotNull
    private int delay; //Время задержки для открытия/закрытия ворот


    @ManyToOne
    private House house;



    public Gate() {
    }

    public Gate(String name, boolean gateOpen, int delay, House house) {
        this.name = name;
        this.gateOpen = gateOpen;
        this.delay = delay;
        this.house = house;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
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

    public boolean isGateOpen() {
        return gateOpen;
    }

    public void setGateOpen(boolean gateOpen) {
        this.gateOpen = gateOpen;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gateOpen=" + gateOpen +
                ", delay=" + delay +
                ", house=" + house.getName() +
                '}';
    }
}
