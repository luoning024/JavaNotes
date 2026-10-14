package N4;

// p162 内部类书中例子
// RedCowForm类里有一个RedCow内部类

public class RedCowForm {
    static String formName;
    RedCow cow;     // 内部类声明对象

    RedCowForm() {}
    RedCowForm(String s) {
        cow = new RedCow(150, 112, 5000);
        formName = s;
    }

    public void showCowMess(){
        cow.mow();
    }

    static class RedCow{   // 内部类
        String cowName = "红牛";
        int height, weight, price;

        RedCow(int h, int w, int p){
            height=h;
            weight=w;
            price=p;
        }

        void mow(){
            System.out.println("我是"+cowName+", 身高为"+height+"cm, 体重"+
                weight+"kg, 生活在"+formName);
        }
    }               // 内部类结束
}                   // 外嵌类结束
