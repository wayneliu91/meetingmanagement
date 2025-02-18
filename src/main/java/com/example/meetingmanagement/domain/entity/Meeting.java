package com.example.meetingmanagement.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Meeting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private boolean isHosted;
  private Long roomId;
  private Long userId;

  public Meeting(
      String title,
      LocalDateTime startTime,
      LocalDateTime endTime,
      boolean isHosted,
      Long roomId,
      Long userId) {
    this.title = title;
    this.startTime = startTime;
    this.endTime = endTime;
    this.isHosted = isHosted;
    this.roomId = roomId;
    this.userId = userId;
  }
}
