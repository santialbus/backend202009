package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.api.entity.TaskEntity;
import com.example.demo.model.TaskDto;

public class TaskUtils {
	
	public static List<TaskDto> listEntityToListDTO(List<TaskEntity> listaEntidades) {
		List<TaskDto> listaDto = new ArrayList<TaskDto>();
		TaskDto taskDto = null;
		if(!listaEntidades.isEmpty()) {
			for (TaskEntity task : listaEntidades) {
				taskDto = new TaskDto();
				taskDto.setId(task.getId());
				taskDto.setDescription(task.getDescription());
				taskDto.setCompleted(task.isCompleted());
				taskDto.setPriority(task.getPriority());
				listaDto.add(taskDto);
			}
		}
		
		return listaDto;
	}
	
	public static TaskDto entityToDTO(TaskEntity entity) {
		TaskDto taskDto = new TaskDto();
		
		taskDto.setId(entity.getId());
		taskDto.setDescription(entity.getDescription());
		taskDto.setCompleted(entity.isCompleted());
		taskDto.setPriority(entity.getPriority());
		
		return taskDto;
	}

	public static TaskEntity dtoToEntity(TaskDto taskDto) {
		TaskEntity entity = new TaskEntity();
		
		entity.setId(taskDto.getId());
		entity.setDescription(taskDto.getDescription());
		entity.setCompleted(taskDto.isCompleted());
		entity.setPriority(taskDto.getPriority());
		
		return entity;
	}
	
}
