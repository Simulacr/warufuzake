package desu.nya.server.entities;

/**
 *
 * @author fess
 */
public interface Item extends GenericEntity{
    
    Measuring getMeasuring();
    void setMeasuring(Measuring measuring);
    
    int getPrice();
    void setPrice(int price);
    
    String getName();
    void setName(String name);
}
