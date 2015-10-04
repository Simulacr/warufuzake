package desu.nya.server.entities.impl;

import desu.nya.server.entities.Item;
import desu.nya.server.entities.Measuring;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author fess
 */
@Entity
@Table(name="ITEM", schema="APP")
public class ItemImpl extends GenericEntityImpl implements Item
{
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="measuring_id")
    private MeasuringImpl measuring;
    @Column(name="price")
    private int price;
    @Column(name="name")
    @Size(min=2,max=50) 
    private String name;

    @Override
    public Measuring getMeasuring() {
        return measuring;
    }

    @Override
    public void setMeasuring(Measuring measuring) {
        this.measuring = (MeasuringImpl)measuring;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
