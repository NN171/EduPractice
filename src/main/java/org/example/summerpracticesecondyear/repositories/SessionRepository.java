package org.example.summerpracticesecondyear.repositories;

import org.example.summerpracticesecondyear.entities.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends BaseRepository<Session, Long> {
}
