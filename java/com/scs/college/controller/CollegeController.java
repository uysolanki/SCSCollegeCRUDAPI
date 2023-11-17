package com.scs.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scs.college.entity.Teacher;
import com.scs.college.response.DeleteResponse;
import com.scs.college.service.TeacherService;

@RestController
@RequestMapping("/wadiacollege")
public class CollegeController {
	
	@Autowired
	TeacherService teacherService;

	@RequestMapping("/get/greet")
	public String greet()
	{
		return "Welcome";
	}
	
	@GetMapping("/get/springboot")
	public String abc()
	{
		return "Welcome To SpringBoot";
	}
	
	@GetMapping("/get/addition")
	public String add()
	{
		int n1=10;
		int n2=20;
		int n3=n1+n2;
		return "Addition is"+n3;
	}
	
	@GetMapping("/get/additionnew")
	public String addnew(@RequestParam("num1") int n1,@RequestParam("num2") int n2 )
	{
		int n3=n1+n2;
		return "Addition is"+n3;
	}
	
	@PostMapping("/post/addTeacher")
	public Teacher addTeacher(@RequestParam("p1") String tname,  //Mark
						      @RequestParam("p2") int tage,      //43
						      @RequestParam("p3") double sal)    //19000
	{
		
		Teacher t1=new Teacher();  //plain object
		t1.setTname(tname);
		t1.setTage(tage);
		t1.setSal(sal);
		return teacherService.addTeacher(t1);
		
	}
	
	@PostMapping("/post/addTeacherByRequestBody")
	public Teacher addTeacherByRequestBody(@RequestBody Teacher t1)
	{
		return teacherService.addTeacher(t1);	
	}
	
	@PostMapping("/post/addTeacherByPathVariable/{t1}/{t2}/{t3}")
	public Teacher addTeacherByPathVariable(@PathVariable("t1") String tname,
											@PathVariable("t2") int tage,
											@PathVariable("t3") double sal)
	{
		Teacher t1=new Teacher();
		t1.setTname(tname);
		t1.setTage(tage);
		t1.setSal(sal);
		return teacherService.addTeacher(t1);	
	}
	
	@PostMapping("/post/addTeacherBySinglePathVariable/{t1}")
	public Teacher addTeacherBySinglePathVariable(@PathVariable("t1") String tname)
	{
		Teacher t1=new Teacher();
		t1.setTname(tname);
		t1.setTage(61);
		t1.setSal(12000);
		return teacherService.addTeacher(t1);	
	}
	//C done
	//R1 get multiple records the teachers, R2 get single teacher - condition tno=1, tsal=max
	//ResponseEntity
	@GetMapping("/get/getAllTeachers")
	public ResponseEntity<List<Teacher>> getAllTeachers()
	{
		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(),HttpStatus.OK);
	}
	
	@GetMapping("/get/getTeacherByTno")
	public ResponseEntity<Teacher> getTeacherByTno(@RequestParam("tno") int teacherNumber)//1
	{
		return new ResponseEntity<Teacher>(teacherService.getTeacherByTno(teacherNumber),HttpStatus.OK);
	}
	
	@GetMapping("/get/getTeacherByTnoUsingPathVariable/{tno}")
	public Teacher getTeacherByTnoUsingPathVariable(@PathVariable("tno") int teacherNumber)//1
	{
		return teacherService.getTeacherByTno(teacherNumber);
	}
	
	@GetMapping("/get/getTeacherByTage")
	public List<Teacher> getTeacherByTage(@RequestParam("t1") int age)//1
	{
		return teacherService.getTeacherByTage(age);
	}
	
	@GetMapping("/get/getTeacherByRange/{t1}/{t2}")
	public List<Teacher> getTeacherByRange(@PathVariable("t1") int sage,
										  @PathVariable("t2") int eage)//1
	{
		return teacherService.getTeacherByRange(sage,eage);
	}
	
	@GetMapping("/get/getTeacherByCustomData")
	public List<Teacher> getTeacherByCustomData()//1
	{
		return teacherService.getTeacherByCustomData();
	}
	
	@GetMapping("/get/getTeacherByCustomAgeAndSalaryParameterised/{t1}/{t2}")
	public List<Teacher> getTeacherByCustomAgeAndSalaryParameterised(@PathVariable("t1") int age,
										  @PathVariable("t2") double salary)//1
	{
		return teacherService.getTeacherByRangePara(age,salary);
	}
	
	@DeleteMapping("/delete/deleteTeacherByTno")
	public DeleteResponse deleteTeacherByTno(@RequestParam("t1") int tno)
	{
		DeleteResponse deleteResponse=new DeleteResponse(); //not success
		try
		{
		teacherService.deleteTeacherByTno(tno);
		}
		catch(Exception e) {
			return deleteResponse;
		}
		
		deleteResponse.setStatus(true);
		deleteResponse.setMessage("Record Deleted Successfully");
		deleteResponse.setHttpStatusCode(HttpStatus.OK);
		return deleteResponse;
	}
	
    @PutMapping("/put/updateTeacher")
    public Teacher updateTeacher(@RequestParam("t1") int tno,
    							 @RequestBody Teacher teacher)
	{
		return teacherService.updateTeacher(tno,teacher);
		
	}
    
    @PutMapping("/put/updateTeacherName")
    public Teacher updateTeacherName(@RequestParam("t1") int tno,
    								 @RequestParam("t2") String tname)
	{
		return teacherService.updateTeacherName(tno,tname);
		
	}
    
    @DeleteMapping("/delete/deleteTeacherByTname")
	public DeleteResponse deleteTeacherByTname(@RequestParam("t1") String tn)
	{
    	DeleteResponse deleteResponse=new DeleteResponse(); //not success
		try
		{
		teacherService.deleteTeacherByTname(tn);
		deleteResponse.setStatus(true);
		deleteResponse.setMessage("Record Deleted Successfully");
		deleteResponse.setHttpStatusCode(HttpStatus.OK);
		return deleteResponse;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return deleteResponse;
	}
    
    @GetMapping("/accesDenied/college")
    public String accessDeniedCollege()
    {
    	return "403 Forbidden";
    }
}
