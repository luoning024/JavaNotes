// p88: import语句
import java.util.Date;

public class APP01 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //p56:区分成员变量和局部变量
        Tom tom = new Tom();
        tom.f();


        // p70:可变参数
        System.out.println(tom.getSum(203,211,273,888));
        

        // p58:类中的“构造方法”
        Person p1 = new Person("dasima");
        System.out.println(p1.name);
        p1.sayHello();


        // p75:类里对象的组合与复用
        SIM sim1 = new SIM(112233);
        Mobile mob = new Mobile();
        mob.setSIM(sim1);
        System.out.println("手机号码： "+ mob.checkNumber());
        SIM sim2 = new SIM(2233345);
        mob.setSIM(sim2);  // 更换手机号
        System.out.println("手机号码： "+ mob.checkNumber());


        // p81:方法重载 method overload
        // Pupil s1 = new Pupil();
        // Pupil s2 = new Pupil("Tom");
        // Pupil s3 = new Pupil("Tom", 20);


        // p88: import语句
        Date date = new Date();
        System.out.println("本地机器时间： "+ date.toString());


        // p99:总结：rational类举例
        // 计算2/1+3/2+5/3..的前n项的和
        int n=10, k=1;
        System.out.println("计算前n项的和");
        Rational sum = new Rational();
        sum.setNumerator(0);
        Rational item = new Rational();
        item.setNumerator(2);
        item.setDenomirator(1);
        while(k<=n){
            sum = sum.add(item);
            k++;
            int fenzi = item.getNumerator();
            int fenmu = item.getDenomirator();
            item.setNumerator(fenzi+fenmu);
            item.setDenomirator(fenzi);
        }
        int uu=sum.getNumerator();
        int pp=sum.getDenomirator();
        System.out.println("用分数表示");
        System.out.println(uu+"/"+pp);
    }



    // p56:区分成员变量和局部变量
    static class Tom {
        int x=10, y;
        void f() {
            int x=5,
            y=x + this.x;    //y=x + this.x;
            System.out.println(y);  //y的值是10
        }


        // p70:可变参数
        int getSum(int... x){
            int sum=0;
            // for (int i=0;i<x.length;i++){
            //     sum=sum+x[i];
            // }
            for (int param : x){
                sum += param;
            }
            return sum;
        }
    }


    // p58:类中的“构造方法”
    static class Person {
        String name;

        // 构造方法
        Person(String name) {
           this.name = name;
        }

        // 普通方法,因为有类型void
        void sayHello() {
            System.out.println("Hello " + name);
        }
    }


    // p75:类里对象的组合与复用
    static class SIM{
        long number;
        SIM(long number){
            this.number = number;
        }
        long getNumber() {
            return number;
        }
    }

    static class Mobile {
        SIM sim;
        void setSIM(SIM card){  // 创建对象时使用SIM类里的对象，以此使用其方法
            sim = card;
        }
        long checkNumber() {
            return sim.getNumber();
        }
    }


    // p81:方法重载 method overload
    static class Pupil {
        String name;
        int age;

        Pupil(){
        }

        Pupil(String name){
            this.name = name;
        }

        Pupil(String name, int age){
            this.name = name;
            this.age = age;
        }
    }



    // p99:总结：rational类举例
    public static class Rational{
        int numerator = 1;      // 分子
        int denomirator = 1;    // 分母

        void setNumerator(int a){               // 设置分子 
            int c = f(Math.abs(a),denomirator); // 计算最大公约数
            numerator = a/c;
            denomirator = denomirator/c;
            if(numerator<0&&denomirator<0){
                numerator = -numerator;
                denomirator = -denomirator;
            }
        }

        void setDenomirator(int b){             // 设置分母
            int c = f(numerator, Math.abs(b));  // 计算最大公约数
            numerator = numerator/c;
            denomirator = b/c;
            if(numerator<0&&denomirator<0){
                numerator = -numerator;
                denomirator = -denomirator;
            }
        }

        int getNumerator(){
            return numerator;
        }

        int getDenomirator(){
            return denomirator;
        }

        int f(int a, int b){                    // 求a和b最大公约数
            if (a==0) return 1;
            if (a<b){
                int c=a;
                a=b;
                b=c;
            }
            int r = a%b;
            while(r!=0){
                a=b;
                b=r;
                r=a%b;
            }
            return b;
        }

        Rational add(Rational r){               // 加法运算
            int a = r.getNumerator();           // 返回r的分子
            int b = r.getDenomirator();         // 返回r的分母
            int newNumerator = numerator*b + denomirator*a;
            int newDenomirator = denomirator*b;
            Rational result = new Rational();
            result.setNumerator(newNumerator);
            result.setDenomirator(newDenomirator);
            return result;
        }

        Rational sub(Rational r){               // 减法运算
            int a = r.getNumerator();           
            int b = r.getDenomirator();         
            int newNumerator = numerator*b - denomirator*a;
            int newDenomirator = denomirator*b;
            Rational result = new Rational();
            result.setNumerator(newNumerator);
            result.setDenomirator(newDenomirator);
            return result;
        }

        Rational muti(Rational r){              // 乘法运算
            int a = r.getNumerator();           
            int b = r.getDenomirator();         
            int newNumerator = numerator*a;
            int newDenomirator = denomirator*b;
            Rational result = new Rational();
            result.setNumerator(newNumerator);
            result.setDenomirator(newDenomirator);
            return result;
        }

        Rational div(Rational r){              // 除法运算
            int a = r.getNumerator();           
            int b = r.getDenomirator();         
            int newNumerator = numerator*b;
            int newDenomirator = denomirator*a;
            Rational result = new Rational();
            result.setNumerator(newNumerator);
            result.setDenomirator(newDenomirator);
            return result;
        }
    }
}
