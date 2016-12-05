/*
 * Decompiled with CFR 0_119.
 */
package com.snaplync.dto;

import com.snaplync.entity.Session;

public class SessionDto {
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static SessionDto getDto(Session session) {
        SessionDto dto = new SessionDto();
        dto.setToken(session.getToken());
        return dto;
    }
}
