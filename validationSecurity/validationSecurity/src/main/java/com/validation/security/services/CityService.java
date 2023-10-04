package com.validation.security.services;

import com.validation.security.dto.CityDTO;
import com.validation.security.entities.City;
import com.validation.security.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> result = cityRepository.findAll(Sort.by("name"));
        return result.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        copyDtoToEntity(entity, dto);
        cityRepository.save(entity);
        return new CityDTO(entity);
    }


    private void copyDtoToEntity(City entity, CityDTO dto) {
        entity.setName(dto.getName());
    }
}
