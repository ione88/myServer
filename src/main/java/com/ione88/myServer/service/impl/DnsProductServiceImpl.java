package com.ione88.myServer.service.impl;

import com.ione88.myServer.entity.DnsProduct;
import com.ione88.myServer.repository.DnsProductRepository;
import com.ione88.myServer.service.DnsProductService;

public class DnsProductServiceImpl implements DnsProductService {

    private DnsProductRepository dnsProductRepository;


    public DnsProductServiceImpl(DnsProductRepository dnsProductRepository){
        this.dnsProductRepository = dnsProductRepository;
    }

    @Override
    public String createDnsProduct(DnsProduct dnsProduct) {
        DnsProduct dnsProductPersist = dnsProductRepository.findByCode(dnsProduct.getCode());
        if (dnsProductPersist == null) {
            dnsProductRepository.save(dnsProduct);
            return "Saved";
        }
        dnsProductPersist.setDescription(dnsProduct.getDescription());
        dnsProductPersist.setName(dnsProduct.getName());
        dnsProductPersist.setParametrsJson(dnsProduct.getParametrsJson());
        dnsProductPersist.setPrice(dnsProduct.getPrice());
        dnsProductPersist.setUrl(dnsProduct.getUrl());
        dnsProductRepository.save(dnsProductPersist);
        return "Update";
    }

}
