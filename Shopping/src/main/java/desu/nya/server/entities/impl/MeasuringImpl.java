package desu.nya.server.entities.impl;

import desu.nya.server.entities.Measuring;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fess
 */
@Entity
@Table(name="MEASURING", schema="APP")
public class MeasuringImpl extends GenericEntityImpl implements Measuring{
    
    @Column(name="unit")
    private String unit;

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
}
