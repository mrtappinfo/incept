/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.stereotype.Repository
 */
package com.snaplync.repository;

import com.snaplync.entity.Industry;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepository
extends PagingAndSortingRepository<Industry, Long> {
    public static final String likeQuery = "select i from Industry i order by i.name asc";
    public static final String findOneQuery = "Select i from Industry i where id = ?1";

    public Industry findByName(String var1);

    @Query(value="select i from Industry i order by i.name asc")
    public Iterable<Industry> findAll();

    @Query(value="Select i from Industry i where id = ?1")
    public Industry findOne(Long var1);
}
