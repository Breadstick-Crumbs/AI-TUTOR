package com.schoolmanagement.repository;

import com.schoolmanagement.entity.TeacherManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entity.Teacher;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
