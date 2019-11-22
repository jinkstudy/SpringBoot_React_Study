package com.practice.projectboard.service;

import org.springframework.stereotype.Service;

import com.practice.projectboard.domain.ProjectTask;
import com.practice.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
		if(projectTask.getStatus() ==null || projectTask.getSummary() =="") {
			projectTask.setStatus("To_Do");
		}
		return projectTaskRepository.save(projectTask) ;
	}
	
	public Iterable<ProjectTask> findAll(){
		return projectTaskRepository.findAll();
	}
	
	public ProjectTask findById(Long id) {
		return projectTaskRepository.getById(id);
	}
}
