package com.nit.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.CourseDetails;
import com.nit.repository.CourseRepository;

@Service
public class CourseServiceIMPL implements CourseService {

	@Autowired 
	CourseRepository repository;
	
	@Override
	public String upsert(CourseDetails course) {
		
		repository.save(course); //upsert(insert/ update based on PK)
		
		return "success";
	}

	@Override
	public CourseDetails getById(Integer id) {
		Optional<CourseDetails> findbyId=repository.findById(id);
		if(findbyId.isPresent()) {
			return findbyId.get();
		}
		return null;
	}

	@Override
	public List<CourseDetails> getAllCourses() {
		return repository.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return "Deleted Succesfully";
		}else {
			return "No Record Found";
		}
	}

}
