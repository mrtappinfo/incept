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
import com.snaplync.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CountryDAOImpl
extends BaseDAO {
    public Iterable<Country> findAll(Sort arg0) {
        return null;
    }

    public Page<Country> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Country arg0) {
    }

    public void delete(Iterable<? extends Country> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Country> findAll() {
        return null;
    }

    public Iterable<Country> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Country findOne(Long arg0) {
        return null;
    }

    public <S extends Country> S save(S arg0) {
        return null;
    }

    public <S extends Country> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public Country findByName(String name) {
        return null;
    }
}
