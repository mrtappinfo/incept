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
import com.snaplync.entity.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CurrencyDAOImpl
extends BaseDAO {
    public Iterable<Currency> findAll(Sort arg0) {
        return null;
    }

    public Page<Currency> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Currency arg0) {
    }

    public void delete(Iterable<? extends Currency> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Currency> findAll() {
        return null;
    }

    public Iterable<Currency> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Currency findOne(Long arg0) {
        return null;
    }

    public <S extends Currency> S save(S arg0) {
        return null;
    }

    public <S extends Currency> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public Currency findByName(String name) {
        return null;
    }
}
