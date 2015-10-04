package desu.nya.server.processors.nihongo.nihongouser;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ievstratov on 07.05.2015.
 */
@Repository("nihongoUserProcessor")
public class NihongoUserProcessorImpl implements NihongoUserProcessor {
  @Autowired
  private SessionFactory sessionFactory;

}
