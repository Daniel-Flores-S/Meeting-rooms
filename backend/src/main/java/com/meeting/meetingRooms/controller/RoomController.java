package com.meeting.meetingRooms.controller;

import com.meeting.meetingRooms.exception.ResourceNotFoundException;
import com.meeting.meetingRooms.model.Room;
import com.meeting.meetingRooms.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository repository;

    @GetMapping("/rooms")
    public List<Room>  getAllRooms() {
        return repository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoundException{
        Room room = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found:: "+id));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return repository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room roomDT ) throws ResourceNotFoundException {
        Room room = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: "+ id));

        room.setName(roomDT.getName());
        room.setData(roomDT.getData());
        room.setStartHour(roomDT.getStartHour());
        room.setEndHour(roomDT.getEndHour());

        final Room updateRoom = repository.save(room);

        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id) throws ResourceNotFoundException{
        Room room = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: "+ id));

        repository.delete(room);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }

}
