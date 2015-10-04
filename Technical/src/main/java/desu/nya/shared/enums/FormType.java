package desu.nya.shared.enums;

/**
 *
 * @author fess
 */
public enum FormType {
    LIST(0), UPDATE(1), VIEW(2), ADD(3);
    
    private final int code;
    
    private FormType(int code){
        this.code = code;
    }
    
    public final int getCode(){
        return code;
    }
            
}
