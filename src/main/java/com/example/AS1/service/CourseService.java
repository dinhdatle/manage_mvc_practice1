package com.example.AS1.service;

import com.example.AS1.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCoursebyById(Long id);
    Course findCourseByName(String name);
    void saveCourse(Course course);
    void deleteCourse(Long id);
}