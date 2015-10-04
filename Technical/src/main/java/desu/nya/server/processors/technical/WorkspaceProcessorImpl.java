package desu.nya.server.processors.technical;

import desu.nya.server.entities.User;
import desu.nya.server.entities.Workspace;
import desu.nya.server.entities.impl.UserImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * User: fess
 * Date: 22.10.14
 * Time: 16:22
 */
@Repository("workspaceProcessor")
public class WorkspaceProcessorImpl implements WorkspaceProcessor {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public Workspace getDefaultWsByUser(User user) {
    return ((UserImpl) sessionFactory.getCurrentSession().load(UserImpl.class, user.getId())).getDefaultWorkspace();
  }

  @Override
  @SuppressWarnings("unchecked")
  @Transactional
  public Set<Workspace> getWsOfUser(User user) {
    return ((UserImpl) sessionFactory.getCurrentSession().load(UserImpl.class, user.getId())).getWorkspaces();
  }
}
