package com.ione88.myServer.repositories;

import com.ione88.myServer.entities.YandexNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("YandexNewsRepository")
public interface YandexNewsRepository extends JpaRepository<YandexNews, Long> {
    List<YandexNews> findByTitleContaining(String title);
    List<YandexNews> findByType(String type);
    YandexNews findByTitle(String title);

}
