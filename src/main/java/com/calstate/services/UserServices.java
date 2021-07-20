package com.calstate.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.calstate.exceptions.EmailAlreadyUsed;
import com.calstate.exceptions.InvalidEmailPassword;
import com.calstate.models.Features;
import com.calstate.models.Prediction;
import com.calstate.models.User;
import com.calstate.models.UserData;
import com.calstate.models.UserForm;
import com.calstate.repositories.UserDAO;

@Service
public class UserServices {

	private static final Logger log = LoggerFactory.getLogger(UserServices.class);

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RestTemplate restTemplate;

	private BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
	
	public List<User> getAllUsers(){
		return userDAO.findAll();
	}

	public UserForm register(UserForm u) {
		if(userDAO.existsByEmail(u.getEmail().toLowerCase())) {
			throw new EmailAlreadyUsed("Email already registered");
		}
		User user = new User();
		user.setEmail(u.getEmail().toLowerCase());
		user.setPassword(encrypt.encode(u.getPassword()));
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		userDAO.save(user);
		return new UserForm(user.getEmail(), "*****", user.getFirstName(), user.getLastName());
	}
	
	public User getUser(UserForm userForm) {
		User user = userDAO.findByEmail(userForm.getEmail().toLowerCase()).orElseThrow(() -> new InvalidEmailPassword("Email or password wrong"));
		
		if(!encrypt.matches(userForm.getPassword(), user.getPassword())) {
			throw new InvalidEmailPassword("Email or password wrong");
		}
		
		user.setEmail("******");
		user.setPassword("*****");
		return user;
	}
	
	public void addData(UserData userData) {
		User user = userDAO.findByEmail(userData.getEmail().toLowerCase()).orElseThrow(() -> new InvalidEmailPassword("Email or password wrong"));
		if(!encrypt.matches(userData.getPassword(), user.getPassword())) {
			throw new InvalidEmailPassword("Email or password wrong");
		}

		try{
			FileWriter wr = new FileWriter(new File(userData.getEmail()+".csv"));
			Thread.sleep(500);
			Scanner in = new Scanner(userData.getData());
			while(in.hasNextLine()) {
				String arr[] = in.nextLine().split(",");
				wr.append(String.join(",", arr));
				wr.append("\n");
			}
			wr.close();
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String time = null;
		Features toSend = null;
		try {
			Runtime.getRuntime().exec("python createFeatures.py " + userData.getEmail());
			File features = new File(userData.getEmail() + "_features.csv");
			Scanner in = new Scanner(features);
			in.nextLine();
			String[] data = in.nextLine().split(",");
			time = data[0];
			toSend = new Features(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14], data[15], data[16], data[17], data[18], data[19], data[20], data[21], data[22], data[23], data[24], data[25], data[26], data[27], data[28], data[29], data[30], data[31], data[32], data[33], data[34], data[35], data[36]);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(toSend.toString(), headers);
		ResponseEntity<Prediction> response = restTemplate.postForEntity("http://127.0.0.1:5000/predict", entity, Prediction.class);
		
		Prediction p = response.getBody();
		log.info(p.toString());
		
		if(p.getT1().equals("1.0") || p.getT2().equals("1.0")) {
			user.getDates().add(time);
			userDAO.save(user);
		}
	}
	
	public void deleteAll() {
		userDAO.deleteAll();
	}
}
