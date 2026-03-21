package com.liquibase.service;

import com.liquibase.entity.School;
import com.liquibase.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository repository;

    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    public List<School> getAllSchools() {
        return repository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return repository.findById(id);
    }

    public School createSchool(School school) {
        return repository.save(school);
    }

    public School updateSchool(Long id, School school) {
        school.setId(id);
        return repository.save(school);
    }

    public void deleteSchool(Long id) {
        repository.deleteById(id);
    }
}