p56:区分成员变量和局部变量
如果成员变量和局部变量名字相同，那么成员变量会被隐藏：见代码p56
代码运行结果的y值是10，不是15. 如果方法f()里没有“int x = 5”那么y将是15.
如果想在该方法里使用隐藏的成员变量，我们需要用到关键字this.
///
static class Tom {
        int x=10, y;
        void f() {
            int x=5,
            y=x + this.x;
            System.out.println(y);  //y的值是15
        }
    }
///
成员变量又默认值，局部变量没有默认值，不给局部变量设置初始值，将无法编译。


p58:类中的“构造方法” constructor
当程序用类创建对象时需使用它的构造方法。类中的构造方法名字必须与类完全相同，而且没有类型。java有默认的构造方法，无参数无语句，可以自定义多个构造方法，但要保证参数不同。


p62:类中方法可以改变成员变量，例如:
///
class Tom {
    String head;
    void Speak (String s) {
        head = "现在变歪了";
        sout(s);
    }
}

psvd {
    Tom t1 = new Tom;
    t1.head = "开始是直着的"；
    t1.speak("要变了吗？");
    sout(t1.head);  //这里的头一开始是“开始是直着的”，用完speak方法后
                    // 变成了“现在变歪了”
}
///


p70:可变参数
如果需要一个getSum方法来计算一系列数字的和，但是不确定到底有多少数字需要计算，这个时候就需要可变参数。可变参数使用“...”来表示若干个参数，这些参数类型必须相同，并且最后一个参数必须是方法的参数列表的最后一个参数，例如:
public void f(int... x)
public void g(double a, int... x) 意思是在方法g中，第一个参数a是double型，第二个至最后一个参数是int型。
如果：
public void f(int... x, int y)则非法，不可以，

**如果有一个数组int[] x = {10, 20, 30}, int sum = 0.
那么对于 x 里面的每一个整数，把它暂时叫做 param，然后执行一次循环。
因此：
for (int i = 0; i < x.length; i++) {
    sum += x[i];
}
可以写成：
for (int param : x) {
    sum += param;
}


p75:类里对象的组合与复用
如果一个对象a组合了对象b，那么对象a就可以委托对象b调用其方法，即对象a以组合的方式服用对象b的方法。
1. 通过组合方式来方法也成为黑盒复用
2. 当前对象可以随时更换所包含对象
例如手机和SIM卡，每个SIM卡代表一个号码，每个手机可以有多个SIM卡，随时更换。


p81:方法重载 method overload
意思：一个类中可以有多个方法具有相同的名字，但这些方法的参数必须不同。
主要用处：对于那些功能相同的方法（仅输入参数不同）很有用，可以渐少不必要的方法名；或者重载构造方法，这样只要给出不同的参数，就能按需创造不同对象。
///
int addTwoInts(int a, int b) {
    return a + b;
}
double addTwoDoubles(double a, double b) {
    return a + b;
}
int addThreeInts(int a, int b, int c) {
    return a + b + c;
}
///

以上代码都在想要写一个求和功能，但由于参数不同，所以创造了三个不同方法。这时可以直接用方法重载：

///
int add(int a, int b) {
    return a + b;
}
double add(double a, double b) {
    return a + b;
}
int add(int a, int b, int c) {
    return a + b + c;
}
///
这样调用的时候直接：
///
add(2, 3);          而非addTwoInts(2, 3);
add(2.5, 3.5);      而非addTwoDoubles(2.5, 3.5);
add(1, 2, 3);       而非addThreeInts(1, 2, 3);
///


p85: this关键字
表示某个对象，可以出现在实例方法和构造方法里，不能出现在类方法里。
///
class B{
    void f() {
        this.g()
        B.h()
    }
    void g(){       // 实例方法，属于某个对象
        System.out.println("ok");
    }
    static void h(){//类方法，不需要创建对象，直接使用
        System.out.println("hello");
    }
}
///


p88: import语句
1.引入其他类库中的类
import java.lang;
import java.util.*;  引入util包中的所有类
import java.util.Date;  只引用Date类
如果不提前import，就必须带着包名使用该类：
java.util.Date date = new Date();


p92:私有变量和私有方法 private
当用某个类在另一个类中创建对象后，如果不希望该对象直接访问自己的变量(即通过“.”运算符来操作自己的成员变量)，就应该把该成员变量的访问权限设置成private。
例如：
///public class Student {
    private int age;
    public void setAge(int age){
        this.age=age;
    }
    public int getAge {
        return age;
    }
}

Student zhang = new Student();
zhang.setAge(23);
System.out.println("zhang的年龄是： "+ zhang.getAge()) //这里不能用zhang.age，
                                                      //因为是private

p94: 保护类和友好类
| 修饰符 | 同类 | 同包 | 不同包子类 | 其他类 |
|---|---:|---:|---:|---:|
| `private` | ✅ | ❌ | ❌ | ❌ |
| `default` | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |


p96：对象数组
如果某个程序需要某个类的若干个对象，就应该使用对象数组。
///
Student stu[] = new Student[10]     // 创建对象数组stu

for(int i=0; i<10 i){
    stu[i] = new Student();        // 依次创建Student对象stu[i]
}


p97:jar文件 Java Archive
本质上类似压缩包，里面有别人已经写好的java功能。把JAR加入项目后，就可以直接使用里面的类。
把.jar放到lib里面，就能直接用了，
项目
├── src
├── lib
│   └── xxx.jar
└── bin
例如:TOOLS包里有个Calculator类，那么直接可以 import tools.Calculator;


p99:总结：rational类举例
有理数的类封装
numerator: int 
denominator: int

setNumeratorAndDenominator(int, int): void
add(Rational): Rational
sub(Rational): Rational
muti(Rational): Rational
div(Rational): Rational


p103:文件"APP01_Ex.java"搭建了一个流水线
用流水线完成分数评定，其中InputScore类负责录入分数，它组合了DelScore类的对象；
DelScore类负责去掉最高分和最低分，它组合了ComputerAver类的对象；
ComputerAver类负责计算平均值；
Line类负责组合以上三个类