package com.schoolmanagement;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.schoolmanagement.service.FileService;

@SpringBootApplication

public class SchoolManagementLoginApplication {
	 @Resource
	  FileService fileService;
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementLoginApplication.class, args);
	}
}
