package com.ione88.myServer.controllers;

import com.ione88.myServer.entities.YandexNews;
import com.ione88.myServer.services.YandexNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller    // This means that this class is a Controller
@RequestMapping(path = "/news") // This means URL's start with /demo (after Application path)
public class YandexNewsController {
    @Autowired
    private YandexNewsService yandexNewsService;


    @GetMapping
    public String news(Map<String, Object> model) {
        model.put("news", yandexNewsService.all());
        return "news";
    }

    @PostMapping(path = "filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        model.put("news", yandexNewsService.filter(filter));
        return "news";
    }

    @PutMapping(path = "/add", consumes = "application/json", produces = "application/json") // Map ONLY PUT Requests
    public @ResponseBody String createYandexNews(@RequestBody YandexNews yandexNews) {
        return yandexNewsService.createYandexNews(yandexNews);
    }

}