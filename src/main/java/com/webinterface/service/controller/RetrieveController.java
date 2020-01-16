package com.webinterface.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.webinterface.service.component.RetrieveServiceImpl;
import com.webinterface.service.domain.RetrieveServiceResponse;


@RestController
@CrossOrigin
public class RetrieveController {

	@Autowired
	public RetrieveServiceImpl retrieveServiceImpl;


	
	@GetMapping(value = "/retrieveRequests/request/{requestId}")
	public ResponseEntity<RetrieveServiceResponse> retrieve(
			@PathVariable String requestId, @RequestHeader("authorizationCode") String authorizationCode) {
		return ResponseEntity.ok(retrieveServiceImpl
				.retrieveRequest(requestId, authorizationCode));
	}
	
	@GetMapping(value = "/retrieveRequests")
	public ResponseEntity<List<RetrieveServiceResponse>> findAll(@RequestHeader("authorizationCode") String authorizationCode) {
		return ResponseEntity.ok(retrieveServiceImpl
				.findAll(authorizationCode));
	}

}