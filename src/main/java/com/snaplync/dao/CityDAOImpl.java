/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.domain.Sort
 *  org.springframework.stereotype.Service
 */
package com.snaplync.dao;

import com.snaplync.dao.BaseDAO;
import com.snaplync.entity.City;
import com.snaplync.entity.State;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CityDAOImpl
extends BaseDAO {
    public Iterable<City> findAll(Sort arg0) {
        return null;
    }

    public Page<City> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(City arg0) {
    }

    public void delete(Iterable<? extends City> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<City> findAll() {
        return null;
    }

    public Iterable<City> findAll(Iterable<Long> arg0) {
        return null;
    }

    public City findOne(Long arg0) {
        return null;
    }

    public <S extends City> S save(S arg0) {
        return null;
    }

    public <S extends City> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public City findByName(String name) {
        return null;
    }

    public City findByNameAndState(String name, State state) {
        return null;
    }

    public List<City> findCityLike(String name, Pageable pageable) {
        return null;
    }
}
