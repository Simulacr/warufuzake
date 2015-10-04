package desu.nya.shared.exceptions;

public class FunctionalException extends Exception
{
  private String messageCode;

  public FunctionalException(String messageCode, String message)
  {
    super(message);
    this.messageCode = messageCode;
  }

  public String getMessageCode(){
    return messageCode;
  }
}
