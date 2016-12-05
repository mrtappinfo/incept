/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 *  org.springframework.data.repository.query.Param
 */
package com.snaplync.repository;

import com.snaplync.entity.Currency;
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CurrencyRepository
extends PagingAndSortingRepository<Currency, Long> {
    public static final String likeQuery = "select s from Currency s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc";
    public static final String getCurrencyQuery = "select s from Currency s where  s.currency_id = ?1";

    @Query(value="select s from Currency s where LOWER(s.name) like CONCAT('%',:name,'%') order by s.name asc")
    public Currency findByName(@Param(value="name") String var1);

    @Query(value="select s from Currency s where  s.currency_id = ?1")
    public Currency findOne(@Param(value="id") Long var1);
}
