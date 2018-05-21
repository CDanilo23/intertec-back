package com.intertec.app;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findById(Integer id);
	
}
