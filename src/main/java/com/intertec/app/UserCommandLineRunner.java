package com.intertec.app;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	Logger logger = Logger.getLogger(UserCommandLineRunner.class.getName());

	@Override
	public void run(String... arg0) throws Exception {
		logger.warning("------------------------------");
		logger.warning("Number of words restricted: "+restrictedWordsRepository.findAll().size());
		logger.warning("Number of usernames already used: "+userNameRepository.findAll().size());
		logger.warning("------------------------------");
	}
	
	@Autowired
	UserRepository userNameRepository;
	
	@Autowired
	RestrictedWordsRepository restrictedWordsRepository;
	
	
}
