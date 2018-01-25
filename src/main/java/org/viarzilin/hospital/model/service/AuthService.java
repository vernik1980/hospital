package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.domain.Auth;

public interface AuthService {

  public void addAuth(Auth auth);

  public void updateAuth(Auth auth);

  public void removeAuth(Integer id);

  public Auth getAuthById(Integer id);

  public List<Auth> listAuthes();
}
