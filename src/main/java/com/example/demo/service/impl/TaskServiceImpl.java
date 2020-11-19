package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.entity.TaskEntity;
import com.example.demo.api.repository.TaskRepository;
import com.example.demo.model.TaskDto;
import com.example.demo.service.TaskService;
import com.example.demo.util.TaskUtils;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<TaskDto> getAllTasks() {
		List<TaskEntity> listaEntidades = taskRepository.findAll();
		return TaskUtils.listEntityToListDTO(listaEntidades);
	}

	@Override
	public TaskDto getTask(int id) {
		Optional<TaskEntity> optionalEntity = taskRepository.findById(id);
		TaskEntity taskEntity = optionalEntity.get();
		return TaskUtils.entityToDTO(taskEntity);
	}

	@Override
	public boolean createTask(TaskDto taskDto) {
		//Buscamos si existe un id con el que nos ha proporcionado
		try {
			TaskEntity entity = TaskUtils.dtoToEntity(taskDto);
			taskRepository.save(entity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateTask(TaskDto taskDto) {
		TaskEntity taskToUpdate = taskRepository.getOne(taskDto.getId());
		
		taskToUpdate.setDescription(taskDto.getDescription());
		taskToUpdate.setCompleted(taskDto.isCompleted());
		taskToUpdate.setPriority(taskDto.getPriority());
		taskRepository.save(taskToUpdate);
		
		return true;
	}

	@Override
	public void deleteTask(int id) {
		taskRepository.delete(taskRepository.getOne(id));
	}
	
}
