package com.ione88.myServer.repository;

import com.ione88.myServer.entity.DnsProductAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository("DnsProductAvailableRepository")
public interface DnsProductAvailableRepository extends JpaRepository<DnsProductAvailable, Long> {
    DnsProductAvailable findByCodeAndCityAndShop(Integer code, String city, String shop);
}
