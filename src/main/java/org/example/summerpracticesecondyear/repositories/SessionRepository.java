package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(value = "select s from Session s " +
            "")
    List<Session> getSessions();
}
