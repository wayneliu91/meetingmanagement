package com.example.meetingmanagement.infrastructure.repository;

import com.example.meetingmanagement.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}