package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn==null) {
			try{
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
				System.out.println("Connection Successful!");
			}catch(SQLException e) {
				Alerts.showAlerts("DataBase Connection", "Connection Failed", "The database connection failed. Please contact the DBA", AlertType.ERROR);
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("Connection Closed!");
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(PreparedStatement st) {
		try{
			st.close();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	public static void closeResultSet(ResultSet rs) {
		try{
			rs.close();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
