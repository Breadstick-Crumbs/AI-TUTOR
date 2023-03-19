package com.schoolmanagement.entity;

import com.schoolmanagement.dto.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Classes classes;
    @OneToOne
    private School school;

    @OneToOne
    private TeacherManagement teacherManagement;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "TEACHER_CLASS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "CLASS_ID")})
    private Set<Classes> classId = new HashSet<>();


    public TeacherDto convertToDto() {
        return TeacherDto.builder().id(id).name(name).build();
    }



}

