package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT +
				" WHERE d.department_id=?";

		try {


			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}

		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong",ex);
		}
		
		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		//step 1 -
		Department dept = null;

		//step 2
		String sql = "INSERT INTO department(name)\n" +
				"VALUES(?) RETURNING department_id;";

		//step 3
		try{
			int deptId = jdbcTemplate.queryForObject(sql,int.class,department.getName());

			//step 4
			dept = getDepartmentById(deptId);

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		//step 5
		return dept;
	}

	@Override
	public Department updateDepartment(Department department) {
		Department updatedDepartment = null;

		String sql = "UPDATE department\n" +
				"SET name = ?\n" +
				"WHERE department_id = ?;";
		try {
			int numOfRows = jdbcTemplate.update(sql,department.getName(),department.getId());
			if (numOfRows == 0){
				throw new DaoException("Zero rows affected, expected at least one");
			} else {
				updatedDepartment = getDepartmentById(department.getId());
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		return updatedDepartment;
	}

	@Override
	public int deleteDepartmentById(int id) {
		int numDeleted = 0;

		String updateSql = "UPDATE employee\n" +
				"SET department_id = 0\n" +
				"WHERE department_id = ?;";
		String deleteSql = "DELETE\n" +
				"FROM department\n" +
				"WHERE department_id = ?;";


		try {
			jdbcTemplate.update(updateSql,id);
			numDeleted = jdbcTemplate.update(deleteSql,id);

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		return numDeleted;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
