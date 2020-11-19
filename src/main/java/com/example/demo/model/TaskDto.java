package com.example.demo.model;

import com.example.demo.api.entity.TaskPriority;

public class TaskDto {
	
	private int id;
    private String description;
    private boolean completed;
    private TaskPriority priority;
    
	public TaskDto(int id, String description, boolean completed, TaskPriority priority) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.priority = priority;
	}

	public TaskDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
    
    
}
