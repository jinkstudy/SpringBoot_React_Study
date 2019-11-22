package com.practice.projectboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.projectboard.domain.ProjectTask;
import com.practice.projectboard.service.ProjectTaskService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin // React가 Spring에 접근가능하도록.
public class ProjectTaskController {
	
	@Autowired
	private ProjectTaskService projectTaskService;
	
	
	@PostMapping("")
	// @Valid annotation을 추가 함으로써 RequestBody에 Error있는 경우 500 --> 400 코드를 얻을 수 있다.
	// 즉 Error에 대한 hint를 얻을 수 있다.
	
	//BindingResult :Errors의 하위 인터페이스로서 폼 값을 커맨드 객체에 바인딩한 결과를 저장하고 에러코드로 메세지를 가져온다.
	public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
			
		}
		
		ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);
		
		return new ResponseEntity<ProjectTask>(newPT,HttpStatus.CREATED); // HttpStatus : 201
		
	}
	
	
	@GetMapping("/all")
	public Iterable<ProjectTask> getAllPTs(){
		return projectTaskService.findAll();
	}
	

	@GetMapping("/{pt_id}")
	public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
		ProjectTask projectTask = projectTaskService.findById(pt_id);
		return new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
	}
 
}
