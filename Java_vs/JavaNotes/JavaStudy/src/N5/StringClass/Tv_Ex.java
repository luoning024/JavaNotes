package N5.StringClass;

import java.util.Date;

public class Tv_Ex {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());    // Date重写的toString方法
        Tv tv = new Tv();
        tv.setPrice(288.99);
        System.out.println(tv.toString());      // super.toString的原始方法
                                                // Tv重写的toString方法
    }
}
