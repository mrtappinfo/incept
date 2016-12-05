/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.domain.Sort
 */
package com.snaplync.dao;

import com.snaplync.dao.BaseDAO;
import com.snaplync.entity.User;
import com.snaplync.repository.UserRepository;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class UserDAOImpl
extends BaseDAO
implements UserRepository {
    public Iterable<User> findAll(Sort sort) {
        return null;
    }

    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    public <S extends User> S save(S entity) {
        try {
            this.saveObject(entity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <S extends User> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public User findOne(Long id) {
        String query = "from User where candidateID = " + id;
        try {
            List userList = this.getDataAccToQuery(query);
            User user = (User)userList.get(0);
            return user;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean exists(Long id) {
        return false;
    }

    public Iterable<User> findAll() {
        return null;
    }

    public Iterable<User> findAll(Iterable<Long> ids) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Long id) {
    }

    public void delete(User entity) {
    }

    public void delete(Iterable<? extends User> entities) {
    }

    public void deleteAll() {
    }

    @Override
    public User findByEmail(String email) {
        String query = "from User where email like " + email;
        try {
            List userList = this.getDataAccToQuery(query);
            User user = (User)userList.get(0);
            if (user != null) {
                return user;
            }
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
