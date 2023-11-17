package com.scs.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scs.college.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
