package com.intertec.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restrictedword {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String word;
	
	public Restrictedword() {
	}
	
	public Restrictedword(String word) {
		super();
		this.word = word;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	
}
