package com.ione88.myServer.repository;

import com.ione88.myServer.entity.DnsProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository("DnsProductRepository")
public interface DnsProductRepository extends JpaRepository<DnsProduct, Long> {
    DnsProduct findByCode(Integer code);
}
