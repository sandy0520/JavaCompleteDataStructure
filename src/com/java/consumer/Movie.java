package com.java.consumer;

public class Movie {

	private String name;
	private String hero;
	private String heroine;
	private String result;
	
	
	public Movie(String name, String hero, String heroine) {
		this.name = name;
		this.hero = hero;
		this.heroine = heroine;
	
	}
	public Movie(String name, String result) {
		this.name = name;
		this.result = result;
	
	}
	public String getName() {
		return name;
	}
	
	public String getHero() {
		return hero;
	}
	
	public String getHeroine() {
		return heroine;
	}
	
	public String getResult() {
		return result;
	}
}
