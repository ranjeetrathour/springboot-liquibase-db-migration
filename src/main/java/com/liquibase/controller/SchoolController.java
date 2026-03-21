package com.liquibase.controller;

import com.liquibase.entity.School;
import com.liquibase.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<School>> getAll() {
        return ResponseEntity.ok(service.getAllSchools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getOne(@PathVariable Long id) {
        return service.getSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<School> create(@RequestBody School school) {
        return ResponseEntity.ok(service.createSchool(school));
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> update(@PathVariable Long id, @RequestBody School school) {
        return ResponseEntity.ok(service.updateSchool(id, school));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }
}