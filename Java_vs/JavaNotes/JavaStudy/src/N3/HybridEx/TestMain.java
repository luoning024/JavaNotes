package N3.HybridEx;

public class TestMain {

    /*

    乒乓球运动员：姓名，年龄，学打乒乓球，说英语
    篮球运动员：姓名，年龄，学打篮球
    乒乓球教练：姓名，年龄，教打乒乓球，说英语
    篮球教练：姓名，年龄，教打篮球
    
    */
    public static void main(String[] args) {
        PingpongSporter pps = new PingpongSporter("樊振东", 30);
        System.out.println(pps.getName() + ", " + pps.getAge());
        pps.study();
        pps.speakEnglish();
    }
}
