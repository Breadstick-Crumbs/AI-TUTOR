package com.schoolmanagement.service;

import com.schoolmanagement.dto.TeacherDto;
import com.schoolmanagement.entity.Teacher;
import com.schoolmanagement.entity.TeacherManagement;
import com.schoolmanagement.response.CommonResponse;

import java.util.List;

public interface TeacherService {
    public CommonResponse createNewTeacher(TeacherDto teacherDto);

    public CommonResponse updateTeacher(TeacherDto teacherDto);

    public CommonResponse readAllTeacher();

    public CommonResponse readTeacher(long id);

    public CommonResponse deleteTeacher(long id);

    public List<TeacherManagement> getBestPerformingTeachers();

    public List<TeacherManagement> getHeadsOfDepartment();

    public List<TeacherManagement> getPrimaryWingTeachers();

    public List<TeacherManagement> getSecondaryWingTeachers();

    public List<TeacherManagement> getTeachersSortedByDepartmentAsc();
}