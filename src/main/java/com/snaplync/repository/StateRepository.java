/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.data.repository.query.Param
 */
package com.snaplync.repository;

import com.snaplync.entity.State;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface StateRepository
extends PagingAndSortingRepository<State, Long> {
    public static final String likeQuery = "select s from State s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc";
    public static final String getstateQuery = "select s from State s where  s.state_id = ?1";

    @Query(value="select s from State s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc")
    public State findByName(@Param(value="name") String var1);

    @Query(value="select s from State s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc")
    public List<State> findStateLike(@Param(value="name") String var1, Pageable var2);

    @Query(value="select s from State s where  s.state_id = ?1")
    public State findOne(Long var1);
}
