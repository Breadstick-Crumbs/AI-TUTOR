package com.schoolmanagement.dto;

import com.schoolmanagement.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private long id;
    private String name;

    public Teacher convertToEntity() {
        return Teacher.builder().id(id).name(name).build();
    }
}
