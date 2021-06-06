package com.meeting.meetingRooms.controller;

import com.meeting.meetingRooms.exception.ResourceNotFoundException;
import com.meeting.meetingRooms.model.Room;
import com.meeting.meetingRooms.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.validation.Valid;


@RestController
@CrossOrigin("http//localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private Repository repository;

    public List<Room>  getAllRooms() {
        
    }

}
