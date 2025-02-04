package com.example.AS1.controller;

import com.example.AS1.entity.Score;
import com.example.AS1.repository.ScoreRepository;
import com.example.AS1.service.CourseService;
import com.example.AS1.service.ScoreService;
import com.example.AS1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;
    private final StudentService studentService;
    private final CourseService courseService;

    public ScoreController(ScoreService scoreService, StudentService studentService, CourseService courseService) {
        this.scoreService = scoreService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String listScores(Model model) {
        model.addAttribute("scores", scoreService.getAllScores());
        return "scores/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourse());
        return "scores/add";
    }

    @PostMapping("/add")
    public String addScore(@ModelAttribute Score score) {
        scoreService.saveScore(score);
        return "redirect:/scores";
    }

    @GetMapping("/delete/{id}")
    public String deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return "redirect:/scores";
    }
}
