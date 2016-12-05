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
import com.snaplync.entity.RecruiterDetails;
import com.snaplync.repository.RecruiterRepository;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecruiterDAOImpl
extends BaseDAO
implements RecruiterRepository {
    public Iterable<RecruiterDetails> findAll(Sort arg0) {
        return null;
    }

    public Page<RecruiterDetails> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(RecruiterDetails arg0) {
    }

    public void delete(Iterable<? extends RecruiterDetails> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<RecruiterDetails> findAll() {
        return null;
    }

    public Iterable<RecruiterDetails> findAll(Iterable<Long> arg0) {
        return null;
    }

    public RecruiterDetails findOne(Long arg0) {
        return null;
    }

    public <S extends RecruiterDetails> S save(S arg0) {
        return null;
    }

    public <S extends RecruiterDetails> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }
}
