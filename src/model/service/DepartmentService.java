package model.service;

import java.util.List;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

public class DepartmentService {
	
	DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){
		return dao.findAll();
	}
	
	
}