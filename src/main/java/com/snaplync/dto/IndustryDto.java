/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.dto.BaseDto;
import com.snaplync.entity.Industry;

public class IndustryDto
implements BaseDto<Industry> {
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

    public static IndustryDto getDto(Industry industry) {
        if (industry == null) {
            return null;
        }
        IndustryDto dto = new IndustryDto();
        dto.setId(industry.getId());
        dto.setName(industry.getName());
        return dto;
    }
}
