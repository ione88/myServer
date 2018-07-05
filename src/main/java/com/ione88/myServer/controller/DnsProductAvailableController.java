package com.ione88.myServer.controller;

import com.ione88.myServer.entity.DnsProductAvailable;
import com.ione88.myServer.repository.DnsProductAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller

@RequestMapping(path="/available") // This means URL's start with /demo (after Application path)
public class DnsProductAvailableController {
				// This means to get the bean called userRepository
	@Autowired	// Which is auto-generated by Spring, we will use it to handle the data
	private DnsProductAvailableRepository dnsProductAvailableRepository;
	//private UserService userService;

	@PostMapping(path="/add", consumes = "application/json", produces = "text/plain") // Map ONLY POST Requests
	public @ResponseBody String createDnsProductAvailable (@RequestBody DnsProductAvailable dnsProductAvailable) {
		DnsProductAvailable dnsProductAvailablePersist = dnsProductAvailableRepository.findByCodeAndCityAndShop(dnsProductAvailable.getCode(), dnsProductAvailable.getCity(), dnsProductAvailable.getShop());
		if (dnsProductAvailablePersist == null) {
			dnsProductAvailableRepository.save(dnsProductAvailable);
			return "Saved";
		}
		dnsProductAvailable.setCount(dnsProductAvailable.getCount());
		dnsProductAvailable.setWaitingDays(dnsProductAvailable.getWaitingDays());

		dnsProductAvailableRepository.save(dnsProductAvailable);
		return "Update";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<DnsProductAvailable> getAllDnsProductAvailable() {
		// This returns a JSON or XML with the users
		return dnsProductAvailableRepository.findAll();
	}
}
