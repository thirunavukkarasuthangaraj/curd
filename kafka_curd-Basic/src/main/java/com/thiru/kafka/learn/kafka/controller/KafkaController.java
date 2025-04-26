package com.thiru.kafka.learn.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thiru.kafka.learn.kafka.producer.KafkaProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducerService producer;

	@PostMapping("/add")
	public String addEmployee(@RequestParam String message) {
		producer.sendAddEmployee(message);
		return "Message sent to ADD topic!";
	}

	@PostMapping("/update")
	public String updateEmployee(@RequestParam String message) {
		producer.sendUpdateEmployee(message);
		return "Message sent to UPDATE topic!";
	}
}
