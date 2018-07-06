package com.ione88.myServer.service.impl;

import com.ione88.myServer.entity.YandexNews;
import com.ione88.myServer.repository.YandexNewsRepository;
import com.ione88.myServer.service.YandexNewsService;

public class YandexNewsServiceImpl implements YandexNewsService {

    private YandexNewsRepository yandexNewsRepository;


    public YandexNewsServiceImpl(YandexNewsRepository yandexNewsRepository){
        this.yandexNewsRepository = yandexNewsRepository;
    }

    @Override
    public String createYandexNews(YandexNews yandexNews) {
        YandexNews newsPersist = yandexNewsRepository.findByTitle(yandexNews.getTitle());
        if (newsPersist == null) {
            yandexNewsRepository.save(yandexNews);
            return "saves";
        }
        newsPersist.setUrl(yandexNews.getUrl());
        yandexNewsRepository.save(newsPersist);
        return "update";
    }
}
