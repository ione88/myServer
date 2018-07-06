package com.ione88.myServer.service.impl;

import com.ione88.myServer.entity.DnsProduct;
import com.ione88.myServer.repository.DnsProductRepository;
import com.ione88.myServer.service.DnsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnsProductServiceImpl implements DnsProductService {

    private DnsProductRepository dnsProductRepository;

    @Autowired
    public void setDnsProductRepository(DnsProductRepository dnsProductRepository){
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

    @Override
    public Iterable<DnsProduct> filter(String filter) {
        List<DnsProduct> dnsProduct;

        if (filter != null && !filter.isEmpty()) {
            dnsProduct = dnsProductRepository.findByNameContaining(filter);
            dnsProduct.addAll(dnsProductRepository.findByDescriptionContaining(filter));
        } else {
            dnsProduct = dnsProductRepository.findAll();
        }

        return dnsProduct;
    }

    @Override
    public Iterable<DnsProduct> all() {
        return dnsProductRepository.findAll();
    }

}
