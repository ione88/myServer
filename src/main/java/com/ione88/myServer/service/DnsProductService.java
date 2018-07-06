package com.ione88.myServer.service;

import com.ione88.myServer.entity.DnsProduct;
import org.springframework.stereotype.Service;

@Service
public interface DnsProductService {
    String createDnsProduct(DnsProduct dnsProduct);
    Iterable<DnsProduct> filter(String filter);
    Iterable<DnsProduct> all();
}
