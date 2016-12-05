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
import com.snaplync.entity.JobSeeker;
import com.snaplync.repository.JobSeekerRepository;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerDAOImpl
extends BaseDAO
implements JobSeekerRepository {
    public Iterable<JobSeeker> findAll(Sort arg0) {
        return null;
    }

    public Page<JobSeeker> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(JobSeeker arg0) {
    }

    public void delete(Iterable<? extends JobSeeker> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<JobSeeker> findAll() {
        return null;
    }

    public Iterable<JobSeeker> findAll(Iterable<Long> arg0) {
        return null;
    }

    public JobSeeker findOne(Long arg0) {
        return null;
    }

    public <S extends JobSeeker> S save(S arg0) {
        return null;
    }

    public <S extends JobSeeker> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }
}
