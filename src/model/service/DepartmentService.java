package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	public List<Department> FindAll(){
		List<Department> list = new ArrayList<>();
		list.add(new Department(1,"Books"));
		list.add(new Department(2,"Fashion"));
		list.add(new Department(3,"Computer"));
		list.add(new Department(4,"Electronics"));
		return list;
	}
}
