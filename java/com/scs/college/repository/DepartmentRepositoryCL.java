package com.scs.college.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scs.college.entity.Department;
import com.scs.college.entity.Student;
import com.scs.college.util.DepartmentMapper;

@Repository
public class DepartmentRepositoryCL {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	StudentRepository studRepo;

	public Department getDeptById(int dno) {
		String query="select * from department where dno=?";
		Department dept=jdbcTemplate.queryForObject(query, new DepartmentMapper(),dno);//dno & dname
		List<Student> studList=studRepo.findByDno(dept.getDno());
		dept.setStudents(studList);
		return dept;
	}

	public List<Department> getAllDept() {
		String query="select * from department";
		List<Department> deptList=jdbcTemplate.query(query, new DepartmentMapper());//dno & dname
		for(int i=0;i<deptList.size();i++ )
		{
		List<Student> studList=studRepo.findByDno(deptList.get(i).getDno());
		deptList.get(i).setStudents(studList);
		}
		return deptList;
	}
	

}
