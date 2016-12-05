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
import com.snaplync.entity.Session;
import com.snaplync.repository.SessionRepository;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SessionDAOImpl
extends BaseDAO
implements SessionRepository {
    public Iterable<Session> findAll(Sort arg0) {
        return null;
    }

    public Page<Session> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Session arg0) {
    }

    public void delete(Iterable<? extends Session> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Session> findAll() {
        return null;
    }

    public Iterable<Session> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Session findOne(Long arg0) {
        return null;
    }

    public <S extends Session> S save(S arg0) {
        return null;
    }

    public <S extends Session> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    @Override
    public Session findByToken(String token) {
        return null;
    }
}
