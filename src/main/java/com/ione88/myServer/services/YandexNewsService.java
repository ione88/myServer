package com.ione88.myServer.services;

import com.ione88.myServer.entities.YandexNews;
import org.springframework.stereotype.Service;


public interface YandexNewsService {
    String createYandexNews(YandexNews yandexNews);
    Iterable<YandexNews> filter(String filter);
    Iterable<YandexNews> all();
}
