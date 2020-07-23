package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import db.DB;
import db.DbException;
import entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn=conn;	
	}
	
	
	
	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		ResultSet rs = null;
		PreparedStatement st = null;
		List<Department> list = new ArrayList<>();
		
		try {
			st = DB.getConnection().prepareStatement("select * from department");
			rs = st.executeQuery();	
			if(rs!=null) {
				while(rs.next()) {
					Department dep = new Department();
					dep.setId(rs.getInt("Id"));
					dep.setName(rs.getString("Name"));
					list.add(dep);
				}
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}	
		
		return list;
	}

}
