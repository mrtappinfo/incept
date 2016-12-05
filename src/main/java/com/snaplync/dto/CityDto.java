/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.BaseDto;
import com.snaplync.entity.City;

public class CityDto
implements BaseDto<City> {
    private Long id;
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CityDto getDto(City t) {
        if (t == null) {
            return null;
        }
        CityDto cityDto = new CityDto();
        cityDto.setId(t.getId());
        cityDto.setName(t.getName());
        return cityDto;
    }
}
