package com.validation.security.services;

import com.validation.security.dto.CityDTO;
import com.validation.security.entities.City;
import com.validation.security.repositories.CityRepository;
import com.validation.security.services.exceptions.DatabaseException;
import com.validation.security.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.validation.security.constants.Constants.*;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> result = cityRepository.findAll();
        List<CityDTO> dto = result.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
        return dto;
    }

    @Transactional(readOnly = true)
    public CityDTO findById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ENTITY_NOT_FOUND));
        return new CityDTO(city);
    }

    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        copyDtoToEntity(entity, dto);
        cityRepository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
        }
        try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(FAIL_IN_REFERENTIAL_INTEGRITY);
        }
    }

    private void copyDtoToEntity(City entity, CityDTO dto) {
        entity.setName(dto.getName());
    }
}
