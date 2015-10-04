package desu.nya.services.technical;

import desu.nya.server.entities.Workspace;

import java.util.Set;

/**
 * User: ievstratov
 * Date: 22.10.14
 * Time: 16:26
 */
public interface WorkspaceService {
  Workspace getDefaultWorkspace();

  Set<Workspace> getAvailableWs();
}
