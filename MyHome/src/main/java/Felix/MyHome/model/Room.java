package Felix.MyHome.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component //без этой аннотации не создастся бин!!!!
@JsonIgnoreProperties (ignoreUnknown = true) //Чтоб не уходил в ошибку при появлении непонятных полей


@Table(name = "room")//можно не указывать, тогда будет дефолтное название
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    ///@JsonView(View.User.class) Можем скрыть видимость некоторых параметров для некоторых пользователей


    @Column(name = "co2_level_fact")
    private int co2LevelFact;

    @Column(name = "co2_level_plan")
    private int co2LevelPlan;



    @Column(name = "valves_are_open")
    private boolean valvesAreOpen;


    @ManyToOne (fetch = FetchType.EAGER)

    private Rekuperator rekuperator;

    public Room(String name, int co2LevelFact, int co2LevelPlan, boolean valvesAreOpen, Rekuperator rekuperator) {
        this.name = name;
        this.co2LevelFact = co2LevelFact;
        this.co2LevelPlan = co2LevelPlan;
        this.valvesAreOpen = valvesAreOpen;
        this.rekuperator = rekuperator;
    }

    public Room() {
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

    public int getCo2LevelFact() {
        return co2LevelFact;
    }

    public void setCo2LevelFact(int co2LevelFact) {
        this.co2LevelFact = co2LevelFact;
    }

    public int getCo2LevelPlan() {
        return co2LevelPlan;
    }

    public void setCo2LevelPlan(int co2LevelPlan) {
        this.co2LevelPlan = co2LevelPlan;
    }

    public boolean isValvesAreOpen() {
        return valvesAreOpen;
    }

    public void setValvesAreOpen(boolean valvesAreOpen) {
        this.valvesAreOpen = valvesAreOpen;
    }

    public Rekuperator getRekuperator() {
        return rekuperator;
    }

    public void setRekuperator(Rekuperator rekuperator) {
        this.rekuperator = rekuperator;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", co2LevelFact=" + co2LevelFact +
                ", co2LevelPlan=" + co2LevelPlan +
                ", valvesAreOpen=" + valvesAreOpen +
                ", rekuperator=" + rekuperator.getName() +
                '}';
    }

}
