package com.scs.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String tname;   //findByTname
	private int tage;  //get all teachers whose age is 43 years  //findByTageLessThan
	private double sal;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Teacher() {}
	public Teacher(int tid, String tname, int tage, double sal) {
		this.tid = tid;
		this.tname = tname;
		this.tage = tage;
		this.sal = sal;
	}
	
	
	
}
