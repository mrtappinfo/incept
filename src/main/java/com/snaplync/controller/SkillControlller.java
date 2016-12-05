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
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package com.snaplync.controller;

import com.snaplync.dto.SkillDto;
import com.snaplync.entity.Skill;
import com.snaplync.repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillControlller {
    private final Logger log;
    @Autowired
    SkillRepository skillRepository;

    public SkillControlller() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/skill/search"})
    @ResponseBody
    public List<SkillDto> getSkillsPaged(@RequestParam String name) {
        if (name == null || name.trim().equals("")) {
            return new ArrayList<SkillDto>();
        }
        PageRequest pageable = new PageRequest(0, 10);
        List<Skill> skills = this.skillRepository.findSkillLike(name.toLowerCase(), (Pageable)pageable);
        ArrayList<SkillDto> skillDtos = new ArrayList<SkillDto>();
        for (Skill skill : skills) {
            skillDtos.add(SkillDto.getDto(skill));
        }
        return skillDtos;
    }
}
