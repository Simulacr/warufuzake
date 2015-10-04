package desu.nya.web.forms;

/**
 *
 * @author fess
 */
public class SpecialButton {
    
    private String code;
    private String action;
    private boolean immediate;
    
    public SpecialButton(String code, String action, boolean immediate){
        this.code = code;
        this.action = action;
        this.immediate = immediate;
    }
    
    public static SpecialButton getSaveButton(){
        return new SpecialButton("Save", "save", false);
    }
    
    public static SpecialButton getCloseButton(){
        return new SpecialButton("Close", "close", true);
    }
    
    public String getCode(){
        return code;
    }
    
    public String getPage(){
        return action;
    }
    
    public boolean isImmediate(){
        return immediate;
    }
}
