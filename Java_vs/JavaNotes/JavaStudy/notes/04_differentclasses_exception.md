p163: 接口匿名类
与接口有关的匿名类：假设Computable是一个接口，那么java允许直接用接口名和一个类体创造一个匿名对象。
如果某个方法的参数是接口类型，那么可以使用接口名和类体组合创建一个匿名对象传递给方法的参数，类体必须重写接口中的全部方法。


p169：断言语句assert
当发生某个错误时，要求程序必须立即停止执行。
语法格式：
assert booleanExpression;
assert booleanExpression : messageExpression;

例如：assert number>=0;
意为如果number>=0为true，程序继续，否则立即停止。


p171: 应用举例
熟悉try catch finally
try{}
catch(ExceptionSubclass e) {}
finally{}

机制：执行try-catch语句后，执行finally语句。也就是说，无论try-catch部分是否异常，finally都会被执行。
但是：
= 若try-catch中有return语句，finally仍然被执行
= try-catch中执行了程序退出代码，即System.exit(0)，则不执行finally

该应用案例包含DangerException.java, CargoBoat.java, App_FinalEx.java文件


拓展1：static变量：保存共享数据
| 加在哪里 | 作用 |
|---|---|
| `static class` | 嵌套类对象不自动关联外部对象 |
| `static` 变量 | 变量属于类，所有对象共享一份 |
| `static` 方法 | 方法属于类，调用时不需要创建该类的对象 |

例如：
///
class Student {
    int score;                    // 实例变量：每个学生各有一份
    static int studentCount = 0;   // 静态变量：整个类共享一份

    Student(int score) {
        this.score = score;
        studentCount++;
    }
}

// 然后创建两个学生

Student alice = new Student(90);
Student bob = new Student(70);

System.out.println(alice.score);          // 90
System.out.println(bob.score);            // 70
System.out.println(Student.studentCount); // 2
///
每调用一次构造器，共享的 studentCount 就加一。这里记录的是累计创建数量，不是当前仍然存活的对象数量。

静态变量也可以修改：Student.studentCount = 100; Java 允许通过对象访问静态变量，例如 alice.studentCount，但推荐写成 Student.studentCount，明确它属于类。

常见用途：
共享计数器。
所有对象共同使用的配置。
配合 final 定义常量。
例如：static final int PASS_SCORE = 60; 该数据共享且不能赋值。


拓展1：static方法：执行不依赖当前对象的操作
例如，判断一个分数是否及格，只需要得到分数，不需要先创建学生：
///
class Student {
    static final int PASS_SCORE = 60;

    static boolean isPassing(int score) {
        return score >= PASS_SCORE;
    }
}

System.out.println(Student.isPassing(90)); // true
System.out.println(Student.isPassing(50)); // false
///

与实例方法对比：
///
class Student {
    int score;

    // 实例方法：判断“当前学生”是否及格
    boolean isPassing() {
        return score >= 60;
    }

    // 静态方法：判断“传入的分数”是否及格
    static boolean isPassing(int score) {
        return score >= 60;
    }
}

Student alice = new Student();
alice.score = 90;

alice.isPassing();      // 使用 Alice 自己的成绩
Student.isPassing(90);  // 使用传入的分数
///

static方法关键规则：静态方法没有“当前对象”，因此没有 this。
///
class Student {
    int score = 80;
    static int studentCount = 0;

    static void printInfo() {
        System.out.println(studentCount); // 可以：静态变量

        // System.out.println(score);     // 错误：哪个学生的成绩？上面的int score属于对象
        // System.out.println(this.score);// 错误：这里没有 this
    }
}
///

但只要明确提供对象，就能访问实例成员：
static void printScore(Student student) {
    System.out.println(student.score);
}
这时候调用：
Student.printScore(alice);

综合案例：
///
public class APP04 {
    public static void main(String[] args) {
        Student alice = new Student("Alice", 90);
        Student bob = new Student("Bob", 70);

        alice.printScore(); // Alice：90
        bob.printScore();   // Bob：70

        System.out.println(Student.studentCount); // 2
        System.out.println(Student.isPassing(50)); // false

        Student.printStudentScore(alice); // 90
    }

    static class Student {
        String name;  // 实例变量
        int score;    // 实例变量

        static int studentCount = 0;     // 静态变量
        static final int PASS_SCORE = 60;// 静态常量

        Student(String name, int score) {
            this.name = name;
            this.score = score;
            studentCount++;
        }

        // 实例方法：使用当前学生的数据
        void printScore() {
            System.out.println(name + "：" + score);
        }

        // 静态方法：使用参数和静态常量
        static boolean isPassing(int marks) {
            return marks >= PASS_SCORE;
        }

        // 静态方法：通过明确提供的对象读取实例变量
        static void printStudentScore(Student student) {
            System.out.println(student.score);
        }
    }
}


实际案例中常用的静态方法和变量:
// 数学计算：不用创建 Math 对象
double root = Math.sqrt(25); // 5.0
int larger = Math.max(90, 70);// 90
int positive = Math.abs(-5); // 5

// 字符串转换为整数
int number = Integer.parseInt("123"); // 123

// 获取当前时间的毫秒值
long time = System.currentTimeMillis();

// 静态常量
double pi = Math.PI;