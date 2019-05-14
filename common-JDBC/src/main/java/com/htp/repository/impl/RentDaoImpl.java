package com.htp.repository.impl;


import com.htp.domain.Rent;
import com.htp.repository.RentDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RentDaoImpl implements RentDao {
    @Override
    public List<Rent> findAll() {
        return null;
    }

    @Override
    public Rent findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Rent save(Rent entity) {
        return null;
    }

    @Override
    public Rent update(Rent entity) {
        return null;
    }
}
