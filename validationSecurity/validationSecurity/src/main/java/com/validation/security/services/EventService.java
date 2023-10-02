package com.validation.security.services;

import com.validation.security.dto.EventDTO;
import com.validation.security.entities.Event;
import com.validation.security.repositories.EventRepository;
import com.validation.security.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.validation.security.constants.Constants.FAIL_IN_REFERENTIAL_INTEGRITY;
import static com.validation.security.constants.Constants.RESOURCE_NOT_FOUND;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<EventDTO> findAll() {
        List<Event> result = eventRepository.findAll();
        List<EventDTO> dto = result.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
        return dto;
    }

    @Transactional(readOnly = true)
    public EventDTO findById(Long id) {
        Optional<Event> obj = eventRepository.findById(id);
        Event entity = obj.orElseThrow(() -> new ResourceNotFoundException(""));
        return new EventDTO(entity);
    }

    @Transactional
    public EventDTO insert(EventDTO eventDTO) {
        Event entity = new Event();
        copyDtoToEntity(eventDTO, entity);
        eventRepository.save(entity);
        return new EventDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
        }
        try {
            eventRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceNotFoundException(FAIL_IN_REFERENTIAL_INTEGRITY);
        }
    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
    }
}
