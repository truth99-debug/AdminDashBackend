package com.intercafe.admin.repository;

import com.intercafe.admin.model.MealModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<MealModel , Long> {

    @Query(
            """
            SELECT
                mm
            FROM
                MealModel mm
            WHERE
                mm.category NOT LIKE '%MOTD%'
            """
    ) List<MealModel> getAll();

    @Query(
            """
            SELECT
                mm
            FROM
                MealModel mm
            WHERE
                mm.category = 'MOTD'
            """
    )MealModel getMealOfTheDay();

}
