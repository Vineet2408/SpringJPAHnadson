package com.cognizant.QuizAttempt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttempt.QuizAttemptDetailsApplication;
import com.cognizant.QuizAttempt.Repository.UserRepository;
import com.cognizant.QuizAttempt.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizAttemptDetailsApplication.class);

	public List<User> getAttempts() {
		return userRepository.findAll();

	}

	@Transactional
	public User get(int id) {
		LOGGER.info("Start");
		return userRepository.findById(id).get();
	}
	
	public User getUserAttempt(int userId,int attemptId) {
		return userRepository.getUserAttempt(userId, attemptId);

	}
}
