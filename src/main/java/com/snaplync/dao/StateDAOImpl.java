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
import com.snaplync.entity.State;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StateDAOImpl
extends BaseDAO {
    public Iterable<State> findAll(Sort arg0) {
        return null;
    }

    public Page<State> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(State arg0) {
    }

    public void delete(Iterable<? extends State> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<State> findAll() {
        return null;
    }

    public Iterable<State> findAll(Iterable<Long> arg0) {
        return null;
    }

    public State findOne(Long arg0) {
        return null;
    }

    public <S extends State> S save(S arg0) {
        return null;
    }

    public <S extends State> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public State findByName(String name) {
        return null;
    }

    public List<State> findStateLike(String name, Pageable pageable) {
        return null;
    }
}
