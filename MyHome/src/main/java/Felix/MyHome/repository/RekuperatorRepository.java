package Felix.MyHome.repository;

import Felix.MyHome.model.Rekuperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RekuperatorRepository extends JpaRepository <Rekuperator, Integer> {
    public Rekuperator findRekuperatorByHouse_Id (int id);
    public Rekuperator findRekuperatorById (int id);

}
