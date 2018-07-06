package com.ione88.myServer.service.impl;

import com.ione88.myServer.entity.DnsProductAvailable;
import com.ione88.myServer.repository.DnsProductAvailableRepository;
import com.ione88.myServer.service.DnsProductAvailableService;

import java.time.LocalDateTime;

public class DnsProductAvailableServiceImpl implements DnsProductAvailableService {

    private DnsProductAvailableRepository dnsProductAvailableRepository;


    public DnsProductAvailableServiceImpl(DnsProductAvailableRepository dnsProductAvailableRepository){
        this.dnsProductAvailableRepository = dnsProductAvailableRepository;
    }

    @Override
    public String createDnsProductAvailable(DnsProductAvailable dnsProductAvailable) {

        DnsProductAvailable dnsProductAvailablePersist = dnsProductAvailableRepository
                .findByCodeAndCityAndShop(dnsProductAvailable.getCode(), dnsProductAvailable.getCity(), dnsProductAvailable.getShop());

        if (dnsProductAvailablePersist == null) {
            dnsProductAvailableRepository.save(dnsProductAvailable);
            return "Saved";
        }
        dnsProductAvailablePersist.setCount(dnsProductAvailable.getCount());
        dnsProductAvailablePersist.setWaitingDays(dnsProductAvailable.getWaitingDays());
        dnsProductAvailablePersist.setUpdated(LocalDateTime.now());

        dnsProductAvailableRepository.save(dnsProductAvailablePersist);
        return "Update";
    }


}
