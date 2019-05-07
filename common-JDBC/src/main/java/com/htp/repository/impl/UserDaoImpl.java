package com.htp.repository.impl;

import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public List<Long> batchUpdate(List<User> users) {
        return null;
    }

    @Override
    public List<User> search(String query, Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
