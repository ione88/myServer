package com.ione88.myServer.controllers;

import com.ione88.myServer.entities.DnsProductAvailable;
import com.ione88.myServer.services.DnsProductAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller

@RequestMapping(path="/available") // This means URL's start with /demo (after Application path)
public class DnsProductAvailableController {

	private DnsProductAvailableService dnsProductAvailableService;
	@Autowired
	public void setDnsProductAvailableController(DnsProductAvailableService dnsProductAvailableService) {
		this.dnsProductAvailableService = dnsProductAvailableService;
	}

	@PutMapping(path="/add", consumes = "application/json", produces = "text/plain") // Map ONLY POST Requests
	public @ResponseBody String createDnsProductAvailable (@RequestBody DnsProductAvailable dnsProductAvailable) {
		return dnsProductAvailableService.createDnsProductAvailable(dnsProductAvailable);

	}
}
