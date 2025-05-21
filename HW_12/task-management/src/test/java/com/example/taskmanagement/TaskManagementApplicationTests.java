package com.example.taskmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskManagementApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateTask() {
		Task newTask = new Task(1L, "Test Task");
		ResponseEntity<Void> response = restTemplate.postForEntity("/tasks", newTask, Void.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void testGetAllTasks() {
		ResponseEntity<Task[]> response = restTemplate.getForEntity("/tasks", Task[].class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).isNotNull();
	}
}
