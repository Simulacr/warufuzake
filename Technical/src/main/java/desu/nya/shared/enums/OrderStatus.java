package desu.nya.shared.enums;

/**
 *
 * @author fess
 */
public enum OrderStatus {
    OPEN(0, "open"), CLOSED(1, "closed"), REJECTED(2, "rejected");
    
    private int code;
    private String style;
    
    private OrderStatus(int code, String style)
    {
        this.code = code;
        this.style = style;
    }
    
    public int getCode()
    {
        return code;
    }
    
    public static OrderStatus convertFromCode(int code)
    {
        switch(code)
        {
            case 0: return OPEN;
            case 1: return CLOSED;
            default: return REJECTED;
        }
    }
    
    public String getStatusStyle()
    {
        return style;
    }
}
