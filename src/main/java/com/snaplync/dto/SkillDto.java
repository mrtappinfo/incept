/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.BaseDto;
import com.snaplync.entity.Skill;

public class SkillDto
implements BaseDto<Skill> {
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

    public static SkillDto getDto(Skill skill) {
        if (skill == null) {
            return null;
        }
        SkillDto dto = new SkillDto();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        return dto;
    }
}
