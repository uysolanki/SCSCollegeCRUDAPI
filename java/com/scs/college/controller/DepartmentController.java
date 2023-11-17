package com.scs.college.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scs.college.entity.Department;
import com.scs.college.service.DepartmentService;

@RestController
@RequestMapping("/wadiacollege")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	private static final Logger logger=Logger.getLogger(DepartmentController.class);
	@PostMapping("/post/addDept/{dname}")
	public Department addDept(@PathVariable("dname") String dname)
	{
		Department dept=new Department();
		dept.setDname(dname);
		logger.info("Departtment Added by name " + dname);
		return deptService.addDept(dept);	
	}
	
	@GetMapping("/get/getDeptById/{dno}")   // getDeptById/1  { dno=1, dname=Science, students [{}{}] }
	public Department getDeptById(@PathVariable("dno") int dno)
	{
		return deptService.getDeptById(dno);
	
	}
	
	@GetMapping("/get/getAllDept")   // getDeptById/1  { dno=1, dname=Science, students [{}{}] }
	public List<Department> getAllDept()
	{
		return deptService.getAllDept();
	
	}
	
	@GetMapping("/accesDenied/dept")
    public String accessDeniedDept()
    {
    	return "403 Forbidden";
    }
}


