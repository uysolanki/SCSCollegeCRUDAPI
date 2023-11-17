package com.scs.college.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scs.college.entity.Department;

public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department d1=new Department();
		d1.setDno(rs.getInt(1));
		d1.setDname(rs.getString(2));
		return d1;
	}

}
