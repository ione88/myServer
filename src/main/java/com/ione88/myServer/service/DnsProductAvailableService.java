package com.ione88.myServer.service;


import com.ione88.myServer.entity.DnsProductAvailable;
import org.springframework.stereotype.Service;

@Service
public interface DnsProductAvailableService {
    String createDnsProductAvailable(DnsProductAvailable dnsProductAvailable);
}
