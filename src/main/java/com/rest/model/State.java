package com.rest.model;

public class State implements Comparable<State>{
	
	String name;
	long population;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	@Override
	public int compareTo(State o) {
		return name.compareTo(o.name);
	}
	
}
