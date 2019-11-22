package com.practice.projectboard.service;

import org.springframework.stereotype.Service;

import com.practice.projectboard.domain.ProjectTask;
import com.practice.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	//새로운 DATA 추가 및 수정
	// JPA에서 ID값이 이미 DB에 존재하는 경우 자동으로 save가 아닌 update 수행
		public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
		if(projectTask.getStatus() ==null || projectTask.getSummary() =="") {
			projectTask.setStatus("To_Do");
		}
		return projectTaskRepository.save(projectTask) ;
	}
	//모든 DATA 찾기
	public Iterable<ProjectTask> findAll(){
		return projectTaskRepository.findAll();
	}
	//ID로 찾기
	public ProjectTask findById(Long id) {
		return projectTaskRepository.getById(id);
	}
	
	//Delete
	public void delete(Long id) {
		ProjectTask projectTask = findById(id);
		projectTaskRepository.delete(projectTask);
	}
}

