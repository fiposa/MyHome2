package Felix.MyHome.service;

import Felix.MyHome.model.Room;
import Felix.MyHome.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;
    private final Room room;

    public RoomService(RoomRepository roomRepository, Room room) {
        this.roomRepository = roomRepository;
        this.room = room;
    }

   public Optional <Room> findRoomById (int id){
        return roomRepository.findRoomById(id);
   }
   public List<Room> findRoomsByRekuperatorId (int id){
        return roomRepository.findRoomsByRekuperatorId(id);
   }



}
