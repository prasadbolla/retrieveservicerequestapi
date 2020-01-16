/**
 * 
 */
package com.webinterface.service.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webinterface.service.domain.RetrieveServiceResponse;
import com.webinterface.service.proxies.RetrieveProxy;


@Component
public class RetrieveServiceImpl {
	@Autowired
	private RetrieveProxy retrieveProxy;
	
	public RetrieveServiceResponse retrieveRequest(String requestId, String authorizationCode ) {
	
		return retrieveProxy.retrieve(requestId, authorizationCode);
	}


	public List<RetrieveServiceResponse> findAll( String authorizationCode ) {
		
		return retrieveProxy.findAll(authorizationCode);
	}

	
}
