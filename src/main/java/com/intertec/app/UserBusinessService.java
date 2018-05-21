package com.intertec.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {
	
	@Autowired
	UserRepository userNameRepository;
	
	@Autowired
	RestrictedWordsRepository restrictedWordsRepository;
	
	public Result <Boolean, List <String>, String> validateUserName(String user) {
		Result<Boolean, List<String>, String> result = null;
		List<String> usernames = new ArrayList<>();
		List<String> restrictedWords = new ArrayList<>();
		String userName;
	    User storagedUserName = userNameRepository.findByUsername(user);
		
		
		Boolean restrictedWord = findRestrictedWordInUsername(user);
		
		
		if (storagedUserName == null && !restrictedWord ) {
			result = new Result<Boolean, List<String>, String>(true, null, null);
		}
		
		if (storagedUserName != null) {
			for (int i = 0; i < 14; i++) {
				userName = storagedUserName.getUsername();
				userName = userName + String.valueOf(i);
				usernames.add(userName);
			}
			result = new Result<Boolean, List<String>, String>(false, usernames,"not available");
		}
		
		if(restrictedWord) {
			restrictedWordsRepository.findAll().forEach(word -> restrictedWords.add(word.getWord()));
			result = new Result<Boolean, List<String>,String>(false, restrictedWords,"restricted");
		}
		
		return result;
	}

	private Boolean findRestrictedWordInUsername(String user) {
		
		StringBuilder patterns = new StringBuilder();
		
		restrictedWordsRepository.findAll().forEach(name -> patterns.append(name.getWord()).append(","));
		
		String [] currentPatterns = patterns.toString().split(","); 
		
		Pattern p;
		Matcher m;
		
		for(String uniquePattern : currentPatterns) {
			p = Pattern.compile(uniquePattern, Pattern.CASE_INSENSITIVE);
			m = p.matcher(user);
			if(m.find()) {
				return true;
			}
		}
		
		return false;
	}
}
