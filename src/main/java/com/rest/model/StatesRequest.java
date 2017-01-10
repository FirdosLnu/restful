package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class StatesRequest {
	private List<State> states = new ArrayList();

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	 
	}