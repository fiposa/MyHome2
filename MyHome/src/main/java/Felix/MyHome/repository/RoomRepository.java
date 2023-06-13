package Felix.MyHome.repository;

import Felix.MyHome.model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room, Integer> {
    public List<Room> findRoomsByRekuperatorId (int id);
    public Optional <Room> findRoomById (int id);
}
