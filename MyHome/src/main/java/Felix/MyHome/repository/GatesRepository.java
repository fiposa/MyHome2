package Felix.MyHome.repository;

import Felix.MyHome.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GatesRepository extends JpaRepository <Gate, Integer> {

    public List<Gate> findGateByHouseId (int id);
    public List<Gate> findGateById (int id);

}
