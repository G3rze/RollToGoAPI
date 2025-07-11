package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room findById(UUID id){
        return roomRepository.findById(id).orElse(null);
    }

    public Room save(Room room){
        return roomRepository.save(room);
    }

    public Room update(Room room){
        return roomRepository.save(room);
    }

    public void deleteById(UUID id){
        roomRepository.deleteById(id);
    }

}
