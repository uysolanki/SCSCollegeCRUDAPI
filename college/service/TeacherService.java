package com.scs.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.college.entity.Teacher;
import com.scs.college.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;

	public Teacher addTeacher(Teacher t1) {
		return teacherRepository.save(t1);
		
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher getTeacherByTno(int teacherNumber) {
		
		return teacherRepository.findById(teacherNumber).get();
	}

	public List<Teacher> getTeacherByTage(int age) {
		return teacherRepository.findByTageLessThan(age);
	}

	public List<Teacher> getTeacherByRange(int sage, int eage) {
		return teacherRepository.findByTageBetween(sage, eage);
	}

	public List<Teacher> getTeacherByCustomData() {
		
		return teacherRepository.findByCustomisedAgeAndSalary();
	}

	public List<Teacher> getTeacherByRangePara(int age, double salary) {
		return teacherRepository.findByCustomisedAgeAndSalaryParameterised(age, salary);
	}

	public void deleteTeacherByTno(int tno) {
		teacherRepository.deleteById(tno);
		
	}

	public Teacher updateTeacher(int tno, Teacher teacherFE) {  //3
		Teacher teacherDb=teacherRepository.findById(tno).get(); //TeacherDb 3 Smith   45 15000
		teacherDb.setTname(teacherFE.getTname());				
		teacherDb.setTage(teacherFE.getTage());
		teacherDb.setSal(teacherFE.getSal());
		return teacherRepository.save(teacherDb);
		
	}

	public Teacher updateTeacherName(int tno, String tname) {
		Teacher teacherDb=teacherRepository.findById(tno).get(); 
		teacherDb.setTname(tname);	
		return teacherRepository.save(teacherDb);
	}

	

}
