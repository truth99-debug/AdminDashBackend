package com.intercafe.admin.repository;

import com.intercafe.admin.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface UsersRepository extends CrudRepository<UserModel , Long> {
    @Query(
            """
            SELECT
                um
            FROM
                UserModel um
            WHERE
                um.userName = ?1
            AND
                um.password = ?2
            """
    )UserModel performLogin(String username , String password);

    @Query(
            """
            SELECT
                um
            FROM
                UserModel um
            """
    ) List<UserModel> getAllUsers();
}
