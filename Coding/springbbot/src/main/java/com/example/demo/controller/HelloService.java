package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Value("${scott.value}")
	private String sCottVal;
	
    public String getHello() {
    	System.out.println(sCottVal);
        return "Hello world";
    }

}
