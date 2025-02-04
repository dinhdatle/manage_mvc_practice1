package com.example.AS1.service;

import com.example.AS1.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> getAllScores();
    Score saveScore(Score score);
    void deleteScore(Long id);
    List<Score> getScoresByStudentAndCourse(Long studentId, Long courseId);
}
