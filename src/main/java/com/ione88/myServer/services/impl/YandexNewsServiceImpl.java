package com.ione88.myServer.services.impl;

import com.ione88.myServer.entities.YandexNews;
import com.ione88.myServer.repositories.YandexNewsRepository;
import com.ione88.myServer.services.YandexNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class YandexNewsServiceImpl implements YandexNewsService {

    @Autowired
    private YandexNewsRepository yandexNewsRepository;

    @Override
    public String createYandexNews(YandexNews yandexNews) {
        YandexNews newsPersist = yandexNewsRepository.findByTitle(yandexNews.getTitle());
        if (newsPersist == null) {
            yandexNewsRepository.save(yandexNews);
            return "saves";
        }
        newsPersist.setUrl(yandexNews.getUrl());
        newsPersist.setUpdated(LocalDateTime.now());
        yandexNewsRepository.save(newsPersist);

        return "update";
    }

    @Override
    public Iterable<YandexNews> filter(String filter) {
        List<YandexNews> yandexNews;
        if (filter != null && !filter.isEmpty()) {
            yandexNews = yandexNewsRepository.findByTitleContaining(filter);
            yandexNews.addAll(yandexNewsRepository.findByType(filter));

        } else {
            yandexNews = yandexNewsRepository.findAll();
        }
        return yandexNews;
    }

    @Override
    public Iterable<YandexNews> all() {
        return yandexNewsRepository.findAll();
    }
}
