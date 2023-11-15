package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT +
				" WHERE p.project_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			if (results.next()) {
				project = mapRowToProject(results);
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}

		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Project projectResult = mapRowToProject(results);
				allProjects.add(projectResult);
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		Project project = null;

		String sql = "INSERT INTO project(name,from_date,to_date)\n" +
				"VALUES (?,?,?) RETURNING project_id";
		try {
			int projectId = jdbcTemplate.queryForObject(sql,int.class,newProject.getName(),newProject.getFromDate(),newProject.getToDate());
			project = getProjectById(projectId);

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		return project;
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (employee_id,project_id)\n" +
				"VALUES (?,?);";
		try{
			int rowAffected = jdbcTemplate.update(sql,employeeId,projectId);
			if (rowAffected == 0){
				throw new DaoException("Zero rows affected, expected at least one");
			}
		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		String sql = "DELETE\n" +
				"FROM project_employee\n" +
				"WHERE employee_id = ? AND project_id = ?;";

		try {
			int rowAffected = jdbcTemplate.update(sql,employeeId,projectId);
			if (rowAffected == 0){
				throw new DaoException("Zero rows affected, expected at least one");
			}

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
	}

	@Override
	public Project updateProject(Project project) {
		Project updatedProject = null;
		String sql = "UPDATE project \n" +
				"SET name = ?,from_date = ?, to_date = ?\n" +
				"WHERE project_id = ?;";
		try {
			int numRows = jdbcTemplate.update(sql,project.getName(),project.getFromDate(),project.getToDate(),project.getId());
			if (numRows == 0){
				throw new DaoException("Zero rows affected, expected at least one");
			} else {
				updatedProject = getProjectById(project.getId());
			}

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		return updatedProject;
	}
	@Override
	public int deleteProjectById(int projectId) {
		int numDeleted = 0;
		String sql = "DELETE\n" +
				"FROM project_employee\n" +
				"WHERE project_id = ?;\n" +
				"DELETE\n" +
				"FROM project\n" +
				"WHERE project_id = ?;";
		try {
			numDeleted = jdbcTemplate.update(sql,projectId,projectId);

		}catch (Exception ex){
			throw new DaoException("something went wrong");
		}
		return numDeleted;
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
