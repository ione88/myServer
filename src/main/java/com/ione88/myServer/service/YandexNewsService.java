package com.ione88.myServer.service;

import com.ione88.myServer.entity.YandexNews;
import org.springframework.stereotype.Service;

@Service
public interface YandexNewsService {
    String createYandexNews(YandexNews yandexNews);
}
