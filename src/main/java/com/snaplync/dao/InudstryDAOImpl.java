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
import com.snaplync.entity.Industry;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InudstryDAOImpl
extends BaseDAO {
    public Iterable<Industry> findAll(Sort arg0) {
        return null;
    }

    public Page<Industry> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Industry arg0) {
    }

    public void delete(Iterable<? extends Industry> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Industry> findAll() {
        String query = "from Industry";
        try {
            List industryList = this.getDataAccToQuery(query);
            Iterator iterator = industryList.iterator();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Iterable<Industry> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Industry findOne(Long arg0) {
        return null;
    }

    public <S extends Industry> S save(S arg0) {
        return null;
    }

    public <S extends Industry> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public Industry findByName(String name) {
        return null;
    }
}
