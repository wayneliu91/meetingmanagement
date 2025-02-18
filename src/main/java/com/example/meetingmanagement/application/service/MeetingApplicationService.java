package com.example.meetingmanagement.application.service;

import com.example.meetingmanagement.domain.entity.Meeting;
import com.example.meetingmanagement.domain.service.MeetingDomainService;
import com.example.meetingmanagement.infrastructure.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingApplicationService {

    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private MeetingDomainService meetingDomainService;

    public List<Meeting> getMeetingsByUser(Long userId) {
        return meetingRepository.findByUserId(userId);
    }

    public List<Meeting> getOptimalMeetings(Long userId) {
        List<Meeting> allMeetings = meetingRepository.findByUserId(userId);
        return meetingDomainService.getOptimalMeetings(allMeetings);
    }
}