package com.cognizant.QuizAttempt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttempt.QuizAttemptDetailsApplication;
import com.cognizant.QuizAttempt.Repository.QuestionRepository;
import com.cognizant.QuizAttempt.model.Question;

@Service
public class QuestionService {

	@Autowired
    QuestionRepository questionRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizAttemptDetailsApplication.class);

	public List<Question> getAttempts() {
		return questionRepository.findAll();

	}

	@Transactional
	public Question get(int id) {
		LOGGER.info("Start");
		return questionRepository.findById(id).get();
	}
	
	public Question getQuestionAttempt(int userId,int attemptId) {
		return questionRepository.getQuestionAttempt(userId, attemptId);

	}
}
