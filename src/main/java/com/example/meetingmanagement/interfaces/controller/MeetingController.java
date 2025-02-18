package com.example.meetingmanagement.interfaces.controller;

import com.example.meetingmanagement.application.service.MeetingApplicationService;
import com.example.meetingmanagement.domain.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingApplicationService meetingApplicationService;

    @GetMapping("/user/{userId}")
    public List<Meeting> getMeetingsByUser(@PathVariable Long userId) {
        return meetingApplicationService.getMeetingsByUser(userId);
    }

    @GetMapping("/user/{userId}/optimal")
    public List<Meeting> getOptimalMeetings(@PathVariable Long userId) {
        return meetingApplicationService.getOptimalMeetings(userId);
    }
}