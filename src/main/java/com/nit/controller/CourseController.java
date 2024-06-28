package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nit.Service.CourseService;
import com.nit.entity.CourseDetails;

@Controller
public class CourseController {

	@Autowired
	CourseService service;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody CourseDetails course){
		String status=service.upsert(course);
		return new ResponseEntity<> (status,HttpStatus.CREATED);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseDetails> getCourse(@PathVariable Integer id){
		CourseDetails course=service.getById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<List<CourseDetails>> getAllCourses(){
		List<CourseDetails> allCourses=service.getAllCourses();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody CourseDetails course){
		String status=service.upsert(course);
		return new ResponseEntity<> (status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable Integer id){
		String status=service.deleteById(id);
		return new ResponseEntity<> (status, HttpStatus.OK);
	}
}
