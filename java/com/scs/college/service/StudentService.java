package com.scs.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.college.entity.Student;
import com.scs.college.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studRepo;

	public Student addStudent(Student student) {
		
		return studRepo.save(student);
	}

	public Student getStudentByRno(int rno) {
		return studRepo.findById(rno).get();
	}

	public List<Student> getStudentByDno(int dno) {
		return studRepo.findByDno(dno);
	}

}
