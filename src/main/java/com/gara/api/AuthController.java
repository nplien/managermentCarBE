package com.gara.api;


import com.gara.model.UserModel;
import com.gara.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Validated
public class AuthController {
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UserService userService;


	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		long start = System.currentTimeMillis();
		logger.info("request login: {}- {}", username,password);
		try {
			if ("".equals(username) || "".equals(password)) {
				return ResponseEntity.status(201).build();
			} else {
				UserModel response = userService.loginPassword(username, password);
				if(response == null) {
					return ResponseEntity.notFound().build();
				}
				return ResponseEntity.ok().body(response);
			}

		} catch (Exception e) {
			logger.error("request login: " + username, e);
			throw e;
		}
	}
}
