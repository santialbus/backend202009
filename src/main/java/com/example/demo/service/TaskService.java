package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TaskDto;

public interface TaskService {
	
	List<TaskDto> getAllTasks();

	TaskDto getTask(int id);
	
	boolean createTask(TaskDto taskDto);
	
	boolean updateTask(TaskDto taskDto);
	
	void deleteTask(int id);
}
