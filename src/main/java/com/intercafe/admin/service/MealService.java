package com.intercafe.admin.service;

import com.intercafe.admin.model.MealModel;
import com.intercafe.admin.repository.MealRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
    public List<MealModel> getAll(){
        return mealRepository.getAll();
    }

    public MealModel getMealOfTheDay(){
        return mealRepository.getMealOfTheDay();
    }

    @Transactional
    @Modifying
    public MealModel updateMealItem(Map<? , ?> body){
        MealModel mealModel = new MealModel(
                Long.valueOf(String.valueOf(body.get("id"))),
                String.valueOf(body.get("category")),
                String.valueOf(body.get("description")),
                String.valueOf(body.get("image")),
                String.valueOf(body.get("name")),
                String.valueOf(body.get("price"))
        );
        return mealRepository.save(mealModel);
    }

}
