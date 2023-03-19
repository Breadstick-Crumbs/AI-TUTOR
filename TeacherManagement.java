package com.schoolmanagement.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TeacherManagement {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacher_id;

    private Float rating;

    private Boolean isHeadOfDepartment;

    private String wing;

    private String department;


}