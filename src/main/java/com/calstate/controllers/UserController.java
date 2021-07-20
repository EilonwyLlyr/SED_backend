package com.calstate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calstate.models.User;
import com.calstate.models.UserData;
import com.calstate.models.UserForm;
import com.calstate.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	//debug purpose remove in final build
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userServices.getAllUsers());
	}
	
	@PutMapping("/data")
	public ResponseEntity<Void> sendData(@RequestBody UserData userData){
		userServices.addData(userData);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserForm> register(@RequestBody UserForm userForm){
		UserForm user = userServices.register(userForm);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/info")
	public ResponseEntity<User> getUser(@RequestBody UserForm userForm){
		User user = userServices.getUser(userForm);
		return ResponseEntity.ok(user);
	}
	
	//debug purpose remove in final build
	@DeleteMapping("/deleteALL")
	public ResponseEntity<User> deleteAll(){
		userServices.deleteAll();
		return ResponseEntity.accepted().build();
	}
}
