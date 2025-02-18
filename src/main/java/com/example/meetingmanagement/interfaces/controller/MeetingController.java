package com.example.meetingmanagement.interfaces.controller;

import com.example.meetingmanagement.application.service.MeetingApplicationService;
import com.example.meetingmanagement.domain.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    private MeetingApplicationService meetingApplicationService;

    @PostMapping("/book")
    public Meeting bookMeeting(@RequestParam String title,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
                               @RequestParam Long roomId,
                               @RequestParam Long userId,
                               @RequestParam boolean isHosted) {
        return meetingApplicationService.bookMeeting(title, startTime, endTime, roomId, userId, isHosted);
    }

    @GetMapping("/user/{userId}")
    public List<Meeting> getMeetingsByUser(@PathVariable Long userId) {
        return meetingApplicationService.getMeetingsByUser(userId);
    }

    @GetMapping("/user/{userId}/optimal")
    public List<Meeting> getOptimalMeetings(@PathVariable Long userId) {
        return meetingApplicationService.getOptimalMeetings(userId);
    }
}