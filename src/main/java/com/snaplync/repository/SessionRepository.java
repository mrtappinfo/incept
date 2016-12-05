/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SessionRepository
extends PagingAndSortingRepository<Session, Long> {
    public static final String likeQuery = "select s from Session s where s.token like CONCAT('%',:token,'%') order by s.token asc";

    @Query(value="select s from Session s where s.token like CONCAT('%',:token,'%') order by s.token asc")
    public Session findByToken(String var1);
}
