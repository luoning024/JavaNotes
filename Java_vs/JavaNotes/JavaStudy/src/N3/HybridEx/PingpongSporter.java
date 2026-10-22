package N3.HybridEx;

public class PingpongSporter extends Sporter implements English{
    
    public PingpongSporter(){}

    public PingpongSporter(String name, int age){
        super(name, age);
    }

    @Override 
    public void speakEnglish(){
        System.out.println("乒乓球运动员说英语");
    }

    @Override 
    public void study(){
        System.out.println("乒乓球运动员在学习如何打乒乓球");
    }
}
