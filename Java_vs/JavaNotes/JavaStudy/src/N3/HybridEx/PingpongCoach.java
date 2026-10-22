package N3.HybridEx;

public class PingpongCoach extends Coach implements English{
    public PingpongCoach(){}

    public PingpongCoach(String name, int age){
        super(name, age);
    }

    @Override 
    public void speakEnglish(){
        System.out.println("乒乓球教练在说英语");
    }

    @Override 
    public void teach(){
        System.out.println("乒乓球教练在教如何打乒乓球");
    }
}
