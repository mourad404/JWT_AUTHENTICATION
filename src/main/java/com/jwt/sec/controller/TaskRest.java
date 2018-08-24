package com.jwt.sec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.sec.model.Task;
import com.jwt.sec.repo.TaskRepo;

@RestController
public class TaskRest {

	@Autowired
	private TaskRepo tr;

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/tasks")
	public List<Task> lisTask() {
		return tr.findAll();
	}

	@Secured(value = { "ROLE_USER" })
	@GetMapping("/tasks/{id}")
	public Task lisTask(@PathVariable Long id) {
		return tr.findById(id).get();
	}

	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/tasksAjt")
	public Task ajouterTask(Task t) {
		return tr.save(t);
	}
}
