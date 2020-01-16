package com.webinterface.service.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.webinterface.service.domain.RetrieveServiceResponse;

@FeignClient(contextId = "ext-retrieveServRequest", name = "extretriveservicerequestapi", url = "http://localhost:8443")
@Component
public interface RetrieveProxy {

	@GetMapping(value = "/ext-retrieveServRequest/retrieveRequests/request/{requestId}")
	public RetrieveServiceResponse retrieve(@PathVariable String requestId,
			@RequestHeader("authorizationCode") String authorizationCode);

	@GetMapping(value = "/ext-retrieveServRequest/retrieveRequests")
	public List<RetrieveServiceResponse> findAll(
			@RequestHeader("authorizationCode") String authorizationCode);
}