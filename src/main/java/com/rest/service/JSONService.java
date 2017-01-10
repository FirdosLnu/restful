package com.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.model.State;
import com.rest.model.StatesRequest;

@Path("/json/states")
public class JSONService {

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response processStates(StatesRequest statesReq) {

		List<State> result = statesReq.getStates().stream() 		
				.filter(x -> x.getPopulation() < 500000)
				.collect(Collectors.toList());	
		
		Collections.sort(result);
		
		statesReq.setStates(result);
		
		return Response.status(201).entity(statesReq).build();
		
	}
	
	public static void main(String[] args) {
		State s1 = new State();
		s1.setName("abc");
		s1.setPopulation(100);
		
		State s2 = new State();
		s2.setName("efg");
		s2.setPopulation(200);
		
		List<State> states = new ArrayList<State>();
		states.add(s1);
		states.add(s2);
		List<State> result = states.stream() 		
				.filter(x -> x.getPopulation() < 200)
				.collect(Collectors.toList());	
		
		Collections.sort(result);
		StatesRequest customersReq = new StatesRequest();
		customersReq.setStates(result);
		
		for(State s : customersReq.getStates()){
			System.out.println(s.getName());
		}
	
	}
	
}