package com.springmvc.etg.dao.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.etg.dao.MySQLConnection;
import com.springmvc.etg.dao.TaskSystemDAO;
import com.springmvc.etg.model.Task;


@Component
public class TaskSystemDAOImpl implements TaskSystemDAO {

	@Autowired
	MySQLConnection mySQLConnectionImpl;
	
	@Override
	public boolean addTask(Task task) throws SQLException {
		boolean flag = false;
		Connection con = mySQLConnectionImpl.getConnection();
		
		try{
			String sql = "insert into Task (taskid,name, ownerid,description,status) values(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, task.getTaskId());
			st.setString(2, task.getName());
			st.setInt(3, task.getOwnerId());
			st.setString(4, task.getDescription());
			st.setString(5, task.getStatus());
			int r = st.executeUpdate();
			con.close();
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public Task getTask(int taskid) {
		Connection con = mySQLConnectionImpl.getConnection();
		Task task = new Task();
		try{
			String sql = "select * from task where taskid = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, taskid);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				task.setTaskId(rs.getInt("taskid"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
			}
			con.close();
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return task;
	}

	@Override
	public int assignOwner(int taskid, int ownerid) {
		Connection con = mySQLConnectionImpl.getConnection();
		int rows=0;
		try {
			String sql = "update task set ownerid=? where taskid = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(2, taskid);
			st.setInt(1, ownerid);
			rows = st.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}

	@Override
	public List<Task> getAllTask() {
		Connection con = mySQLConnectionImpl.getConnection();
		List<Task> tasklist = new ArrayList<Task>();
		try {
			String sql = "select * from task";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setTaskId(rs.getInt("taskid"));
				task.setName(rs.getString("name"));
				task.setDescription(rs.getString("description"));
				tasklist.add(task);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tasklist;
	}


}
