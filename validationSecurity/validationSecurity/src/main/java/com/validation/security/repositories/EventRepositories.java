package com.validation.security.repositories;

import com.validation.security.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositories extends JpaRepository<Event, Long> {
}
