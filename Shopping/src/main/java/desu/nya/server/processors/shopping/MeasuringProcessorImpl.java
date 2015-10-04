package desu.nya.server.processors.shopping;

import desu.nya.server.entities.Measuring;
import desu.nya.server.entities.impl.MeasuringImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fess
 */
@Repository("measuringProcessor")
public class MeasuringProcessorImpl implements MeasuringProcessor{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Measuring> getMeasuringList() {
        return sessionFactory.getCurrentSession().createCriteria(MeasuringImpl.class).list();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Measuring getMeasuringByUnit(String unit) {
        return (Measuring)sessionFactory.getCurrentSession().createCriteria(MeasuringImpl.class)
                .add(Restrictions.eq("unit", unit)).uniqueResult();
    }

    @Override
    public Measuring createNewMeasuring() {
        return new MeasuringImpl();
    }

    @Override
    public void addMeasuring(Measuring measuring) {
       sessionFactory.getCurrentSession().save(measuring);;
    }
    
}
