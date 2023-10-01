package com.validation.security.services;

import com.validation.security.dto.EventDTO;
import com.validation.security.entities.Event;
import com.validation.security.repositories.EventRepository;
import com.validation.security.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public EventDTO findById(Long id) {
        Optional<Event> obj = eventRepository.findById(id);
        Event entity = obj.orElseThrow(() -> new ResourceNotFoundException(""));
        return new EventDTO(entity);
    }
}
