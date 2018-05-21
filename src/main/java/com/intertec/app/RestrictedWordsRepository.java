package com.intertec.app;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestrictedWordsRepository extends JpaRepository<Restrictedword, Long>{
	
	@Query("SELECT w from Restrictedword w WHERE w.word LIKE %:user%")
	Restrictedword findRestrictedWordInUsername(@Param("user") String user);
	
	Restrictedword findById(Integer id);
	
	List<Restrictedword> findAll();	
	
}
