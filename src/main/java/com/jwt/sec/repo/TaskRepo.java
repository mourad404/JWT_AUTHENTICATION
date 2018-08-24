package com.jwt.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.sec.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
