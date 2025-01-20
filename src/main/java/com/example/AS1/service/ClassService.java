package com.example.AS1.service;

import com.example.AS1.entity.Class;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    Class saveClass(Class c);
    void deleteClass(Class c);
    List<Class> getAllClasses();

}
