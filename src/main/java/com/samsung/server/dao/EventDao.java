package com.samsung.server.dao;

import com.samsung.server.domain.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDao extends JpaRepository<Event, Integer> {

    @Override
    @EntityGraph(attributePaths = {"users", "comments"}) // Решение N + 1, по сути внутри join
    List<Event> findAll();


}
