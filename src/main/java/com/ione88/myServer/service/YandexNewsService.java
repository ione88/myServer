package com.ione88.myServer.service;

import com.ione88.myServer.entity.YandexNews;

public interface YandexNewsService {
    String createYandexNews(YandexNews yandexNews);
    Iterable<YandexNews> filter(String filter);
    Iterable<YandexNews> all();
}
