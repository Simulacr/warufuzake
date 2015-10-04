package desu.nya.server.entities.impl;

import desu.nya.server.entities.Locution;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fess
 */
@Entity
@Table(name="LOCUTION", schema="APP")
public class LocutionImpl extends GenericEntityImpl implements Locution{

    private String name;
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }    
}
