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
import com.snaplync.entity.TimeUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TimeUnitDAOImpl
extends BaseDAO {
    public Iterable<TimeUnit> findAll(Sort arg0) {
        return null;
    }

    public Page<TimeUnit> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(TimeUnit arg0) {
    }

    public void delete(Iterable<? extends TimeUnit> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<TimeUnit> findAll() {
        return null;
    }

    public Iterable<TimeUnit> findAll(Iterable<Long> arg0) {
        return null;
    }

    public TimeUnit findOne(Long arg0) {
        return null;
    }

    public <S extends TimeUnit> S save(S arg0) {
        return null;
    }

    public <S extends TimeUnit> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public TimeUnit findByName(String name) {
        return null;
    }
}
