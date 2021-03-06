
package org.viarzilin.hospital.model.dao.impl;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.viarzilin.hospital.model.dao.UserDao;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.AuthService;



@Repository
public class UserDaoImpl implements UserDao{

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

  @Autowired
  AuthService authService;

  @Autowired
  SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void addUser(User user) {
    user.setCreateDate(new java.util.Date());
    getSession().persist(user);
    LOGGER.info("User successfully saved. User details: " + user);
  }

  @Override
  public void updateUser(User user) {
    user.setUpdateDate(new java.util.Date());
    getSession().update(user);
    LOGGER.info("User successfully update. User details: " + user);
  }

  @Override
  public void removeUser(Integer id) {

    User user = (User) getSession().load(User.class, id);

    if(user !=null){
      getSession().delete(user);
    }
    LOGGER.info("User successfully removed. User details: " + user);
  }

  @Override
  public User getUserById(Integer id) {

    User user = (User) getSession().load(User.class, id);
    LOGGER.info("User successfully loaded. User details: " + user);

    return user;
  }

  @Override
  @SuppressWarnings("unchecked")
  public User getUserByUsername(String username) {

    Query query = getSession().createQuery("from User where auth.username = :username");
    query.setParameter("username", username);
    User user = (User)  query.uniqueResult();
    LOGGER.info("Userdetails successfully loaded. User details: " + user);

    return user;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> listUsers() {

    List<User> userList = getSession().createQuery("from User ORDER BY lastname ASC").list();

    for(User user : userList){
      LOGGER.info("User list: " + user);
    }

    return userList;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> listUsersByRoleDoctor() {
    List<User> doctorList = getSession().createQuery("from User where auth.isActive='1' "
        + "and auth.role='ROLE_DOCTOR' ORDER BY lastname ASC").list();
    for(User user : doctorList){
      LOGGER.info("Doctor list: " + user);
    }
    return doctorList;
  }

}
