package com.example.meetingmanagement.infrastructure.repository;

import com.example.meetingmanagement.domain.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByUserId(Long userId);
}