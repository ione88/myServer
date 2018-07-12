package com.ione88.myServer.controllers;

import com.ione88.myServer.entities.DnsProduct;
import com.ione88.myServer.services.DnsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller    // This means that this class is a Controller

@RequestMapping(path="/product") // This means URL's start with /demo (after Application path)
public class DnsProductController {
	@Autowired
	private DnsProductService dnsProductService;

	@GetMapping
	public String product(Map<String, Object> model) {
		model.put("product", dnsProductService.all());
		return "product";
	}

	@PostMapping(path="filter")
	public String filter(@RequestParam String filter, Map<String, Object> model) {
		model.put("product", dnsProductService.filter(filter));
		return "product";
	}

	@PutMapping(path="/add", consumes = "application/json", produces = "text/plain") // Map ONLY POST Requests
	public @ResponseBody String createDnsProduct (@RequestBody DnsProduct dnsProduct) {
		return dnsProductService.createDnsProduct(dnsProduct);
	}

}
