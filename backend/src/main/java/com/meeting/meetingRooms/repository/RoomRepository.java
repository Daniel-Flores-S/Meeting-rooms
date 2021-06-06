package com.meeting.meetingRooms.repository;

import com.meeting.meetingRooms.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoomRepository extends JpaRepository<Room,Long>{
}
