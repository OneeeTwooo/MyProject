package com.htp.repository.impl;

import com.htp.domain.Damage;
import com.htp.repository.DamageDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DamageDaoImpl implements DamageDao {
    @Override
    public List<Damage> findAll() {
        return null;
    }

    @Override
    public Damage findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Damage save(Damage entity) {
        return null;
    }

    @Override
    public Damage update(Damage entity) {
        return null;
    }
}
