package Felix.MyHome.repository;

import Felix.MyHome.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {




    public Optional <House> findHouseById (int id);

    public List<House> findHousesByUserId (int id);

    public List<House> findHousesByUser_Email (String email);

    public void deleteHouseById (int id);





    };





