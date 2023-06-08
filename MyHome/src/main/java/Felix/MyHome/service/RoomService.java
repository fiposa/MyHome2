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

    public List<Room> findRoomsByRekuperatorId (int id){
        return null;//roomRepository.findRoomsByRecuperatorId(id);
    }

    public Optional<Room>  changeValue(Integer Co2LevelMaxValue, Integer Co2LevelMinValue,
                                       Optional<Room> room){
        room.get().setCo2LevelMax(Co2LevelMaxValue);
        room.get().setCo2LevelMin(Co2LevelMinValue);

        return room;
    }



}
