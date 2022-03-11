package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;
	
    @GetMapping(path = "/world")
    public ResponseEntity<String> getTemplateForAntenna() {
        return ResponseEntity.ok(helloService.getHello());
    }

}
