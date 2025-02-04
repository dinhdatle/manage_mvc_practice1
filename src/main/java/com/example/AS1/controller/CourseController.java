package com.example.AS1.controller;

import com.example.AS1.entity.Course;
import com.example.AS1.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses", courses);
        return "courses/list";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses/add";
    }

    @PostMapping("/add")
    public String addCourse(Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, Model model) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCoursebyById(id));
        return "courses/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCourse(@ModelAttribute Course course, @PathVariable Long id)
    {
        course.setId(id);
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
}
