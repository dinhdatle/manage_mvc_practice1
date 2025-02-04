package com.example.AS1.service.impl;

import com.example.AS1.entity.Course;
import com.example.AS1.repository.CourseRepository;
import com.example.AS1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCoursebyById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Course findCourseByName(String name) {
        return null;
    }

    @Override
    public void saveCourse(Course course) {
         courseRepository.save(course);

    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);

    }


}
