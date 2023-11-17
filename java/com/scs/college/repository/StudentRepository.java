package com.scs.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scs.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	public List<Student> findByDno(int dno);
}
