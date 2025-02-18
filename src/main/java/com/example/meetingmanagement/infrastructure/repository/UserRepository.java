package com.example.meetingmanagement.infrastructure.repository;

import com.example.meetingmanagement.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}