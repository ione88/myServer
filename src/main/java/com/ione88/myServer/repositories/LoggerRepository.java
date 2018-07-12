package com.ione88.myServer.repositories;

import com.ione88.myServer.entities.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository("LoggerRepository")
public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
