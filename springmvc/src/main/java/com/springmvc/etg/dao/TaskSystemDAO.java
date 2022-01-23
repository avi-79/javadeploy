package com.springmvc.etg.dao;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.etg.model.Task;


public interface TaskSystemDAO {
	public boolean addTask(Task task) throws SQLException;
	public Task getTask(int taskid);
	public int assignOwner(int taskid, int ownerid);
	public List<Task> getAllTask();
}
