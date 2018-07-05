package com.ione88.myServer.controller;

import com.ione88.myServer.entity.YandexNews;
import com.ione88.myServer.repository.YandexNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/news") // This means URL's start with /demo (after Application path)
public class YandexNewsController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
    private YandexNewsRepository yandexNewsRepository;

	@PostMapping(path="/add", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
	public @ResponseBody String createYandexNews (@RequestBody YandexNews yandexNews) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		YandexNews newsPersist = yandexNewsRepository.findByTitle(yandexNews.getTitle());
		if (newsPersist == null) {
			yandexNewsRepository.save(yandexNews);
			return "Saved";
		}
        newsPersist.setUrl(yandexNews.getUrl());
		yandexNewsRepository.save(newsPersist);
		return "Update";
	}

	@GetMapping(path="/all")
	public @ResponseBody
	Iterable<YandexNews> getAllUsers() {
		// This returns a JSON or XML with the users
		return yandexNewsRepository.findAll();
	}


}