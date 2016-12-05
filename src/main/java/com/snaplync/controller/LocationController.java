/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.data.domain.PageRequest
 *  org.springframework.data.domain.Pageable
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package com.snaplync.controller;

import com.snaplync.dto.CityDto;
import com.snaplync.dto.StateDto;
import com.snaplync.entity.City;
import com.snaplync.entity.State;
import com.snaplync.repository.CityRepository;
import com.snaplync.repository.StateRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController {
    private final Logger log;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    StateRepository stateRepository;

    public LocationController() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/state"})
    @ResponseBody
    public Iterable<StateDto> getStates() {
        Iterable states = this.stateRepository.findAll();
        ArrayList<StateDto> stateDtos = new ArrayList<StateDto>();
        for (State state : states) {
            stateDtos.add(StateDto.getDto(state));
        }
        return stateDtos;
    }

    @RequestMapping(value={"/state/search"})
    @ResponseBody
    public Iterable<StateDto> getStateSearch(@RequestParam String name) {
        if (name == null || name.trim().equals("")) {
            return new ArrayList<StateDto>();
        }
        PageRequest pageable = new PageRequest(0, 10);
        List<State> states = this.stateRepository.findStateLike(name.toLowerCase(), (Pageable)pageable);
        ArrayList<StateDto> stateDtos = new ArrayList<StateDto>();
        for (State state : states) {
            stateDtos.add(StateDto.getDto(state));
        }
        return stateDtos;
    }

    @RequestMapping(value={"/city/search"})
    @ResponseBody
    public Iterable<CityDto> getCitySearch(@RequestParam String name) {
        if (name == null || name.trim().equals("")) {
            return new ArrayList<CityDto>();
        }
        PageRequest pageable = new PageRequest(0, 10);
        List<City> cities = this.cityRepository.findCityLike(name.toLowerCase(), (Pageable)pageable);
        ArrayList<CityDto> cityDtos = new ArrayList<CityDto>();
        for (City city : cities) {
            cityDtos.add(CityDto.getDto(city));
        }
        return cityDtos;
    }

    @RequestMapping(value={"/state/{id}"})
    @ResponseBody
    public State getState(@PathVariable Long id) {
        return this.stateRepository.findOne(id);
    }
}
