package com.shoot.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoot.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@PostMapping(value = "/users")
	public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO) {
		return userDTO;
	}

}
