package com.schoolmanagement.repository;

import com.schoolmanagement.entity.TeacherManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherManagementRepository extends JpaRepository<TeacherManagement, Long> {
    List<TeacherManagement> findAllByOrderByRatingDesc();
    List<TeacherManagement> findByIsHeadOfDepartmentTrue();
    List<TeacherManagement> findByWing(String wing);
    List<TeacherManagement> findAllByOrderByDepartmentAsc();
}
