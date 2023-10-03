package com.validation.security.dto;

import com.validation.security.entities.City;
import jakarta.validation.constraints.NotBlank;

public class CityDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;

    public CityDTO() {
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(City entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
