package com.ione88.myServer.repositories;

import com.ione88.myServer.entities.DnsProductAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DnsProductAvailableRepository")
public interface DnsProductAvailableRepository extends JpaRepository<DnsProductAvailable, Long> {
    DnsProductAvailable findByCodeAndCityAndShop(Integer code, String city, String shop);
}
