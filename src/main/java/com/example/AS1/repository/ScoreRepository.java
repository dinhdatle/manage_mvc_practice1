package com.example.AS1.repository;

import com.example.AS1.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByStudentIdAndCourseId(Long studentId, Long courseId);

}