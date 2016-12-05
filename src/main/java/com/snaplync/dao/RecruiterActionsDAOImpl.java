/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.PersistenceContext
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.domain.Sort
 */
package com.snaplync.dao;

import com.snaplync.dao.BaseDAO;
import com.snaplync.entity.Recruiter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RecruiterActionsDAOImpl
extends BaseDAO {
    Logger logger = LoggerFactory.getLogger(RecruiterActionsDAOImpl.class);
    @PersistenceContext
    private EntityManager em;

    public Iterable<Recruiter> findAll(Sort sort) {
        return null;
    }

    public Page<Recruiter> findAll(Pageable pageable) {
        return null;
    }

    public <S extends Recruiter> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    public Recruiter findOne(Long id) {
        return null;
    }

    public boolean exists(Long id) {
        return false;
    }

    public Iterable<Recruiter> findAll() {
        return null;
    }

    public Iterable<Recruiter> findAll(Iterable<Long> ids) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long id) {
    }

    public void delete(Recruiter entity) {
    }

    public void delete(Iterable<? extends Recruiter> entities) {
    }

    public void deleteAll() {
    }

    public List<Recruiter> findSalaryRange(Long actualSalary) {
        this.logger.info("actualSalary" + actualSalary);
        Long highRange = actualSalary + 30000;
        Long lowRange = actualSalary - 30000;
        this.logger.info("highRange" + highRange);
        this.logger.info("lowRange" + lowRange);
        String query = "select  recruiter from Recruiter as recruiter INNER JOIN recruiter.recruiterRateRange as recruiterRange  where  recruiterRange.recruiterRateMin between " + actualSalary + " and " + highRange + " order by recruiterRange.recruiterRateMin desc";
        try {
            List recruiterList = this.getDataAccToQuery(query);
            return recruiterList;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <S extends Recruiter> S save(S arg0) {
        return null;
    }
}
