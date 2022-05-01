package com.java.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MovieUI {

	public static void addMovies(ArrayList<Movie> elist) {
		
		elist.add(new Movie("Bahubali","Prabhas","Anushka"));
		elist.add(new Movie("Bahubali-2","Prabhas","Anushka"));
		elist.add(new Movie("RRR","RamCharan","Alia"));
	}
	public static void main(String[] args) {
		
		ArrayList<Movie> mlist = new ArrayList<>();
		
		addMovies(mlist);
		
		//consumer to print the movie information to the console
		
		Consumer<Movie> c = s ->{
			System.out.println(s.getName());
			System.out.println(s.getHero());
			System.out.println(s.getHeroine());
			System.out.println("******************************");
		};
		
		//calling consumer 
		for(Movie m : mlist) {
			c.accept(m);
		}
		
		//Consumer Chaining ---andThen() only one default method in consumer interface
		Consumer<Movie> c1 = m->System.out.println("Movie: "+m.getName()+" is ready to release");
		Consumer<Movie> c2 = m->System.out.println("Movie: "+m.getName()+" is released and the result is: "+ m.getResult());
		Consumer<Movie> c3 = m->System.out.println("Movie: "+m.getName()+" information is stored in the database"+"\n");
		Consumer<Movie> chainedC = c1.andThen(c2).andThen(c3);
		
		Movie m1 = new Movie("Bahubali", "Hit");
		Movie m2 = new Movie("Acharaya", "Flop");
		
		chainedC.accept(m1);
		chainedC.accept(m2);
	}
}
