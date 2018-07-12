package com.ione88.myServer.repositories;

import com.ione88.myServer.entities.DnsProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DnsProductRepository")
public interface DnsProductRepository extends JpaRepository<DnsProduct, Long> {
    List<DnsProduct> findByNameContaining(String name);
    List<DnsProduct> findByDescriptionContaining(String description);
    DnsProduct findByCode(Integer code);
}
