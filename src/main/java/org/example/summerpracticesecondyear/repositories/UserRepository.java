package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    @Query(value = "select u.bonusBalance from User u " +
            "where u.id = :userId")
    double findBalanceByUserId(@Param("userId") Long userId);

    @Query(value = "select m.genre from User u " +
            "join u.viewHistory m " +
            "where u.id = :userId " +
            "group by m.genre " +
            "order by count(m) desc " +
            "limit 1")
    String findGenreByUserId(@Param("userId") Long userId);
}
