package com.intercafe.admin.controller;

import com.intercafe.admin.model.MealModel;
import com.intercafe.admin.service.MealService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/admin")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/getMeals") private List<MealModel> getAll(){
        return mealService.getAll();
    }

    @GetMapping("/getMealOfTheDay") private MealModel getMealOfTheDay() {return mealService.getMealOfTheDay();}

    @PostMapping("/updateMealItem") private MealModel updateMealItem(@RequestBody() Map <? , ?> body){return mealService.updateMealItem(body);}
}
