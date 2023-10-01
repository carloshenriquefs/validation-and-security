package com.validation.security.services;

import com.validation.security.dto.CityDTO;
import com.validation.security.entities.City;
import com.validation.security.repositories.CityRepository;
import com.validation.security.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.validation.security.constants.Constants.ENTITY_NOT_FOUND;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public CityDTO findById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ENTITY_NOT_FOUND));
        return new CityDTO(city);
    }
}
