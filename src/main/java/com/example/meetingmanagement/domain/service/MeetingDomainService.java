package com.example.meetingmanagement.domain.service;

import com.example.meetingmanagement.domain.entity.Meeting;
import com.example.meetingmanagement.domain.entity.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingDomainService {
  public List<Meeting> getOptimalMeetings(List<Meeting> allMeetings) {
    List<Meeting> attendedMeetings = new ArrayList<>();
    // 筛选出自己主持的会议
    for (Meeting meeting : allMeetings) {
      if (meeting.isHosted()) {
        attendedMeetings.add(meeting);
      }
    }
    // 移除与已参加会议冲突的会议
    List<Meeting> remainingMeetings = new ArrayList<>();
    for (Meeting meeting : allMeetings) {
      if (!meeting.isHosted()) {
        boolean conflict = false;
        for (Meeting attended : attendedMeetings) {
          if (meeting.getStartTime().isBefore(attended.getEndTime())
              && meeting.getEndTime().isAfter(attended.getStartTime())) {
            conflict = true;
            break;
          }
        }
        if (!conflict) {
          remainingMeetings.add(meeting);
        }
      }
    }
    // 按照会议结束时间排序
    remainingMeetings.sort(Comparator.comparing(Meeting::getEndTime));
    // 贪心算法选择会议
    for (Meeting meeting : remainingMeetings) {
      boolean conflict = false;
      for (Meeting attended : attendedMeetings) {
        if (meeting.getStartTime().isBefore(attended.getEndTime())
            && meeting.getEndTime().isAfter(attended.getStartTime())) {
          conflict = true;
          break;
        }
      }
      if (!conflict) {
        attendedMeetings.add(meeting);
      }
    }
    return attendedMeetings;
  }

  public boolean isRoomAvailable(
      Room room, LocalDateTime startTime, LocalDateTime endTime, List<Meeting> existingMeetings) {
    for (Meeting meeting : existingMeetings) {
      if (meeting.getRoomId().equals(room.getId())
          && ((startTime.isBefore(meeting.getEndTime())
              && endTime.isAfter(meeting.getStartTime())))) {
        return false;
      }
    }
    return true;
  }
}
