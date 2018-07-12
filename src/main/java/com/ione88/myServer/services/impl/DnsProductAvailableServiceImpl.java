package com.ione88.myServer.services.impl;

import com.ione88.myServer.entities.DnsProductAvailable;
import com.ione88.myServer.repositories.DnsProductAvailableRepository;
import com.ione88.myServer.services.DnsProductAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DnsProductAvailableServiceImpl implements DnsProductAvailableService {

    @Autowired
    private DnsProductAvailableRepository dnsProductAvailableRepository;

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
