package com.kai.api.welcomecontroller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.api.model.CategoryDto;
import com.kai.service.category.ICategoryService;


@Controller
public class WelcomeController {
    
    @Autowired
    ICategoryService categoryDao;
    
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
	LocalDate to = LocalDate.now();
	LocalDate from = LocalDate.of(2016, Month.APRIL, 1);
	long time = ChronoUnit.DAYS.between(from, to);
	model.put("time", time);
	model.put("abc", "Woooooooooooorking");
	int i = 0;
	for(CategoryDto c : categoryDao.getAll()) {
	    model.put(String.valueOf(i), c.getName());
	    model.put("ctype" + i, c.getType());
	    i++;
	}
	return "welcome";
    }
    
}
