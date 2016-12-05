/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.data.repository.query.Param
 */
package com.snaplync.repository;

import com.snaplync.entity.TimeUnit;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TimeUnitRepository
extends PagingAndSortingRepository<TimeUnit, Long> {
    public static final String likeQuery = "select s from TimeUnit s where s.name like CONCAT('%',:name,'%') order by s.name asc";
    public static final String getTimeUnitQuery = "select s from TimeUnit s where  s.timeunit_id = ?1";

    @Query(value="select s from TimeUnit s where s.name like CONCAT('%',:name,'%') order by s.name asc")
    public TimeUnit findByName(@Param(value="name") String var1);

    @Query(value="select s from TimeUnit s where  s.timeunit_id = ?1")
    public TimeUnit findOne(Long var1);
}
