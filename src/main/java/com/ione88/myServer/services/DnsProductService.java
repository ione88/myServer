package com.ione88.myServer.services;

import com.ione88.myServer.entities.DnsProduct;
import org.springframework.stereotype.Service;


public interface DnsProductService {
    String createDnsProduct(DnsProduct dnsProduct);
    Iterable<DnsProduct> filter(String filter);
    Iterable<DnsProduct> all();
}
