package com.scs.college.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scs.college.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	public List<Teacher> findByTageLessThan(int age);
	
	public List<Teacher> findByTageBetween(int x,int y);
	
	@Query(value="select * from Teacher where tage<=50 and sal>=10000", nativeQuery = true)
	public List<Teacher> findByCustomisedAgeAndSalary();
	
	@Query(value="select * from Teacher where tage<=?1 and sal>=?2", nativeQuery = true)
	public List<Teacher> findByCustomisedAgeAndSalaryParameterised(int age,double salary);
	
	@Transactional
	public void deleteByTname(String y);

}
