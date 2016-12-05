/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.BaseDto;
import com.snaplync.dto.CityDto;
import com.snaplync.entity.City;
import com.snaplync.entity.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StateDto
implements BaseDto<State> {
    private Long id;
    private String name;
    private List<CityDto> cities;

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

    public static StateDto getDto(State t) {
        if (t == null) {
            return null;
        }
        StateDto stateDto = new StateDto();
        stateDto.setId(t.getId());
        stateDto.setName(t.getName());
        ArrayList<CityDto> cityDtos = new ArrayList<CityDto>();
        for (City city : t.getCities()) {
            cityDtos.add(CityDto.getDto(city));
        }
        stateDto.setCities(cityDtos);
        return stateDto;
    }

    public List<CityDto> getCities() {
        return this.cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }
}
