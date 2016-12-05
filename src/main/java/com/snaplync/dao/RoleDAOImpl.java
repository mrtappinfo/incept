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
import com.snaplync.entity.Role;
import java.util.Iterator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RoleDAOImpl
extends BaseDAO {
    public Iterable<Role> findAll(Sort arg0) {
        return null;
    }

    public Page<Role> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Role arg0) {
    }

    public void delete(Iterable<? extends Role> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Role> findAll() {
        String query = "from Role";
        try {
            Iterable iterator = (Iterable)((Object)this.findAll(query));
            return iterator;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Iterable<Role> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Role findOne(Long arg0) {
        return null;
    }

    public <S extends Role> S save(S arg0) {
        return null;
    }

    public <S extends Role> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public Role findByName(String name) {
        return null;
    }
}
