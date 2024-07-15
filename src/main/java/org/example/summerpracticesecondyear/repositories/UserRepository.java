package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    @Query(value = "select u.bonusBalance from User u " +
            "where u.id = :userId")
    double getBonusBalance(@Param("userId") Long userId);
}
