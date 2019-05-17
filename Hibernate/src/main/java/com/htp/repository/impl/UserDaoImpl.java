package com.htp.repository.impl;

import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;

  //    @Autowired
  //    private EntityManagerFactory entityManagerFactory;

  @Override
  public List<User> findAll() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("select tu from User tu", User.class).getResultList();
    }
    //
    //        EntityManager entityManager = entityManagerFactory.createEntityManager();
    //        System.out.println(entityManager.toString());
    //        return entityManager.createQuery("select tu from TestUser tu",
    // TestUser.class).getResultList();
  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public void delete(Long id) {}

  @Override
  public User save(User entity) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      Long newUserID = (Long) session.save(entity);
      transaction.commit();
      return session.find(User.class, newUserID);
    }
  }

  @Override
  public User update(User entity) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.getTransaction();
      transaction.begin();
      session.saveOrUpdate(entity);
      transaction.commit();
      return session.find(User.class, entity.getUserId());
    }
  }

  @Override
  public User findByLogin(String login) {
    return null;
  }
}
