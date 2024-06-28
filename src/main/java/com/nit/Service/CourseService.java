package com.nit.Service;

import java.util.List;

import com.nit.entity.CourseDetails;

public interface CourseService {

	public String upsert(CourseDetails course);
	
	public CourseDetails getById(Integer id);
	
	public List<CourseDetails> getAllCourses();
	
	public String deleteById(Integer id);
	
}
