package N5.StringClass;

public class Tv {
    double price;
    public void setPrice(double m){
        price = m;
    }

    public String toString(){
        String oldStr = super.toString();   // 调用隐藏的Object类的toString方法
        return oldStr+"\n 这是电视机，价格是:"+price;
    }
}
