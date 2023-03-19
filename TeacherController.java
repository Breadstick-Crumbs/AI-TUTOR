package com.schoolmanagement.controller;

import com.schoolmanagement.dto.TeacherDto;
import com.schoolmanagement.entity.Teacher;
import com.schoolmanagement.entity.TeacherManagement;
import com.schoolmanagement.repository.TeacherRepository;
import com.schoolmanagement.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTeacher")
    public ResponseEntity<?> createNewAddress(@RequestBody TeacherDto teacherDto) {
        logger.info("Teacher Dto: " + teacherDto);
        return new ResponseEntity<>(teacherService.createNewTeacher(teacherDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateTeacher")
    public ResponseEntity<?> updateTeacher(@RequestBody TeacherDto teacherDto) {
        logger.info("Teacher Dto: " + teacherDto);
        return new ResponseEntity<>(teacherService.updateTeacher(teacherDto), HttpStatus.CREATED);
    }

    @GetMapping("/readTeacher/{id}")
    public ResponseEntity<?> readTeacher(@PathVariable Long id) {
        logger.info("Inside Read Teacher Api ");
        return new ResponseEntity<>(teacherService.readTeacher(id), HttpStatus.OK);
    }

    @GetMapping("/readTeacher")
    public ResponseEntity<?> readAllTeacher() {
        logger.info("Inside Read All Teacher Api ");
        return new ResponseEntity<>(teacherService.readAllTeacher(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        logger.info("Inside Delete Teacher Api ");
        return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.OK);
    }

    @GetMapping("/best-performing")
    public ResponseEntity<?> getBestPerformingTeachers(){
        logger.info("Inside Best Performing Teacher API ");
        return new ResponseEntity<>(teacherService.getBestPerformingTeachers(), HttpStatus.OK);
    }

    @GetMapping("/heads-of-department")
    public ResponseEntity<?> getHeadsOfDepartment(){
        logger.info("Inside Get Heads of Department API ");
        return new ResponseEntity<>(teacherService.getHeadsOfDepartment(), HttpStatus.OK);
    }

    @GetMapping("/primary-wing")
    public ResponseEntity<?> getPrimaryWingTeachers(){
        logger.info("Inside Primary Wing API ");
        return new ResponseEntity<>(teacherService.getPrimaryWingTeachers(), HttpStatus.OK);
    }

    @GetMapping("/secondary-wing")
    public ResponseEntity<?> getSecondaryWingTeachers(){
        logger.info("Inside Secondary Wing API ");
        return new ResponseEntity<>(teacherService.getSecondaryWingTeachers(), HttpStatus.OK);
    }

    @GetMapping("/sorted-by-department")
    public ResponseEntity<?> getTeachersSortedByDepartment(){
        logger.info("Inside Teachers sorted by Department API");
        return new ResponseEntity<>(teacherService.getTeachersSortedByDepartmentAsc(), HttpStatus.OK);

    }
}