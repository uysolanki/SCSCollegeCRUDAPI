package com.scs.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.college.entity.Department;
import com.scs.college.repository.DepartmentRepository;
import com.scs.college.repository.DepartmentRepositoryCL;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	DepartmentRepositoryCL deptRepoCL;
	
	public Department addDept(Department dept) {
		return deptRepo.save(dept);
	}

	public Department getDeptById(int dno) {
		return deptRepoCL.getDeptById(dno);
	}

	public List<Department> getAllDept() {
		return deptRepoCL.getAllDept();
	}

}
