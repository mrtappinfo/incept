/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.jpa.repository.Query
 *  org.springframework.data.repository.PagingAndSortingRepository
 */
package com.snaplync.repository;

import com.snaplync.entity.City;
import com.snaplync.entity.State;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository
extends PagingAndSortingRepository<City, Long> {
    public static final String likeQuery = "select s from City s where LOWER(s.name) like %?1";
    public static final String getCityQuery = "select s from City s where s.city_id = ?1";

    @Query(value="select s from City s where LOWER(s.name) like %?1")
    public City findByName(String var1);

    @Query(value="select s from City s where LOWER(s.name) like %?1")
    public List<City> findCityLike(String var1, Pageable var2);

    public City findByNameAndState(String var1, State var2);

    @Query(value="select s from City s where s.city_id = ?1")
    public City findOne(Long var1);
}
