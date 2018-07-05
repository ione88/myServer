package com.ione88.myServer.repository;

import com.ione88.myServer.entity.YandexNews;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface YandexNewsRepository extends JpaRepository<YandexNews, Long> {
    YandexNews findByTitle(String title);
}
