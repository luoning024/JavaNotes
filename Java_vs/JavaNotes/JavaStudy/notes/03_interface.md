p145: interface 数据类型接口
定义接口包含接口声明和接口体。接口体只有抽象方法，没有普通方法。且访问权限一定是public static。
///
interface Printable{
    public static final MAX = 100;
    public abstract void add();
    public abstract float sum(float x, float y);    // 这里的public abstract可以被省略
}
///


p146: 重写接口中的方法
如果一个非抽象类实现了某个接口，那么这个类必须重写这个接口中的所有方法。需要注意的是，由于接口的方法一定是public abstract方法，所以类在重写接口方法时不仅要去掉abstract修饰符，给出方法体，而且方法的访问权限一定要明显的用public来修饰（否则就是友好型，视为降低访问权限）。
如果一个类声明实现一个接口，但没有重写接口中的所有方法，那么这个类必须是抽象类。

接口细节说明：
1.定义接口时，如果interface前面加上public，那么这个接口是可以被任何一个类实现。如果不加public，就称作友好接口，友好接口可以被与该接口在同一个包中的类实现。
2.如果父类实现了某个接口，那么子类自然就实现了接口，子类不再需要使用implements声明实现该接口。


p151:接口回调与理解接口
在右边的例子中，要求clasa MotorVehicles的子类Taxi和Bus必须有名字为brake的方法，但额外要求Taxi实现两个接口：controlAirTemperature和charge；要求Bus实现一个接口：charge。


p154：接口参数
如果一个方法的参数是接口类型，我们可以将任何“实现该接口的类的实例的引用”传递给该接口参数，那么接口参数就可以回调类实现的接口方法。
///
interface speakHello {
    void speakHello();
}

class Chinese implements speakHello {
    public void speakHello(){
        sout("中国人习惯问你好吗");
    }
}

class English implements speakHello {
    public void speakHello(){
        sout("英国人习惯问你今天过得怎么样");
    }
}

class KindHello {
    public void lookHello(speakHello hello){    // 接口类型参数
        hello.speakHello();                     // 接口回调
    }
}

public class Example {
    psvmain (){
        KindHello kHello = new KindHello();
        kHello.lookHello(new Chinese());        // 中国人习惯问你好吗
        kHello.lookHello(new English());        // 英国人习惯问你今天过得怎么样
    }
}
///

abstract和接口比较：
1.abstract类和接口都可以有abstract方法
2.abstract类中既可以有常量，也可以有变量；接口只可以有常量
3.abstract类中也可以有非abstract方法，接口不可以


