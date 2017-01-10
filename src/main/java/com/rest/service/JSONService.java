package com.rest.service;

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
				.filter(x -> (x.getPopulation() < 500000 || !x.getName().startsWith("A")))
				.collect(Collectors.toList());	
		
		Collections.sort(result);
		
		statesReq.setStates(result);
		
		return Response.status(201).entity(statesReq).build();
		
	}
}