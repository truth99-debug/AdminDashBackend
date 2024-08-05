package com.intercafe.admin.repository;

import com.intercafe.admin.model.OrdersModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<OrdersModel , Long> {

    @Query(
            """
            SELECT
                om
            FROM
                OrdersModel om
            """
    ) List<OrdersModel> getAllOrders();

}
