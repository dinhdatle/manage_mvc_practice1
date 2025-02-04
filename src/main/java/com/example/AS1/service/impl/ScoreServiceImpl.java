package com.example.AS1.service.impl;

import com.example.AS1.entity.Score;
import com.example.AS1.repository.ScoreRepository;
import com.example.AS1.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

    @Override
    public List<Score> getScoresByStudentAndCourse(Long studentId, Long courseId) {
        return scoreRepository.findByStudentIdAndCourseId(studentId, courseId);
    }
}
