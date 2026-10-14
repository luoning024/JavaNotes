package N4.APP04;

public class DangerException extends Exception{
    final String message = "超重";
    public String wardMess(){
        return message;
    }
}
