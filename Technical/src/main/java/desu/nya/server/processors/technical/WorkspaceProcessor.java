package desu.nya.server.processors.technical;

import desu.nya.server.entities.User;
import desu.nya.server.entities.Workspace;

import java.util.List;
import java.util.Set;

/**
 * User: ievstratov
 * Date: 22.10.14
 * Time: 16:21
 */
public interface WorkspaceProcessor {

  Workspace getDefaultWsByUser(User user);

  Set<Workspace> getWsOfUser(User user);
}
