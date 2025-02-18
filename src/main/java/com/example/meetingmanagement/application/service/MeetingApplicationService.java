package com.example.meetingmanagement.application.service;

import com.example.meetingmanagement.domain.entity.Meeting;
import com.example.meetingmanagement.domain.entity.Room;
import com.example.meetingmanagement.domain.service.MeetingDomainService;
import com.example.meetingmanagement.infrastructure.repository.MeetingRepository;
import com.example.meetingmanagement.infrastructure.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingApplicationService {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MeetingDomainService meetingDomainService;

    public Meeting bookMeeting(String title, LocalDateTime startTime, LocalDateTime endTime, Long roomId, Long userId, boolean isHosted) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) {
            return null;
        }
        List<Meeting> existingMeetings = meetingRepository.findByRoomId(roomId);
        if (!meetingDomainService.isRoomAvailable(room, startTime, endTime, existingMeetings)) {
            return null;
        }
        Meeting meeting = new Meeting(title, startTime, endTime, isHosted, roomId, userId);
        return meetingRepository.save(meeting);
    }

    public List<Meeting> getMeetingsByUser(Long userId) {
        return meetingRepository.findByUserId(userId);
    }

    public List<Meeting> getOptimalMeetings(Long userId) {
        List<Meeting> allMeetings = meetingRepository.findByUserId(userId);
        return meetingDomainService.getOptimalMeetings(allMeetings);
    }
}