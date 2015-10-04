package desu.nya.services.technical;

import desu.nya.server.entities.Workspace;
import desu.nya.server.processors.technical.WorkspaceProcessor;
import desu.nya.shared.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * User: ievstratov
 * Date: 22.10.14
 * Time: 16:27
 */
@Service("workspaceService")
public class WorkspaceServiceImpl implements WorkspaceService{
  @Autowired
  private WorkspaceProcessor workspaceProcessor;

  @Override
  public Workspace getDefaultWorkspace() {
    return workspaceProcessor.getDefaultWsByUser(UserUtils.getCurrentUser());
  }

  @Override
  public Set<Workspace> getAvailableWs() {
    return workspaceProcessor.getWsOfUser(UserUtils.getCurrentUser());
  }
}
