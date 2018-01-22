package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.entity.User;

public interface UserDao {
  public void addUser(User user);

  public void updateUser(User user);

  public void removeUser(Integer id);

  public User getUserById(Integer id);

  public List<User> listUsers();

}