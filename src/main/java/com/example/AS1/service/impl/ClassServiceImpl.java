package com.example.AS1.service.impl;

import com.example.AS1.entity.Class;
import com.example.AS1.repository.ClassRepository;
import com.example.AS1.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class saveClass(Class c) {
        return classRepository.save(c);
    }

    @Override
    public void deleteClass(Class c) {
        classRepository.delete(c);
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
}
