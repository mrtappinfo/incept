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
import com.snaplync.entity.Skill;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SkillDAOImpl
extends BaseDAO {
    public Iterable<Skill> findAll(Sort arg0) {
        return null;
    }

    public Page<Skill> findAll(Pageable arg0) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long arg0) {
    }

    public void delete(Skill arg0) {
    }

    public void delete(Iterable<? extends Skill> arg0) {
    }

    public void deleteAll() {
    }

    public boolean exists(Long arg0) {
        return false;
    }

    public Iterable<Skill> findAll() {
        String query = "from Skill";
        try {
            Iterable iterator = (Iterable)((Object)this.findAll(query));
            return iterator;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Iterable<Skill> findAll(Iterable<Long> arg0) {
        return null;
    }

    public Skill findOne(Long arg0) {
        return null;
    }

    public <S extends Skill> S save(S arg0) {
        return null;
    }

    public <S extends Skill> Iterable<S> save(Iterable<S> arg0) {
        return null;
    }

    public Skill findByName(String name) {
        return null;
    }

    public List<Skill> findSkillLike(String name, Pageable pageable) {
        return null;
    }
}
