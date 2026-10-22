p112:子类与父类
class 子类 extends 父类 {} 一个子类只能有一个父类


p113:子类的继承性
在同一个包中，子类可以继承父类中不是private的成员变量与方法
不在同一个包中时，子类只继承protected和public访问权限的变量和方法，无法继承private和友好变量与方法。


p117: instanceof运算符
用于判断一个对象是不是某个类（或其子类）的实例，结果是true/false
例如：
///
class Animal {}
class Dog extends Animal {}

Dog d = new Dog();

System.out.println(d instanceof Dog);      为true
System.out.println(d instanceof Animal);   为true
///
因为 Dog 本身是 Dog，同时 Dog 也是 Animal 的子类。

///
Animal a = new Dog();

System.out.println(a instanceof Dog);     为true
System.out.println(a instanceof Animal);  为true
///
虽然变量 a 的类型写的是 Animal，但它实际指向的是：new Dog()，因为都true。

通常用于在类型转换前先判断，避免转换错误。
例如：
///
Animal a = new Dog();

if (a instanceof Dog) {
    Dog d = (Dog) a;
}
///


p117: 成员变量的隐藏
在编写子类时，如果新声明的成员变量和从父类继承来的相同，那么这种情况下子类会隐藏继承来的变量。
例如父类有double weight，但子类新声明了int weight，这时double weight就会被隐藏，创建对象设置weight时不可以是double，只能是int。


p118: 方法重写 override
子类可以通过重写隐藏已继承的方法
重写时，子类的类型，方法名字，参数个数，参数类型需要和父类完全相同。
重写父类方法时，不可以降低方法的访问权限，但可以提高。
高->低：public, protected, 友好型, private


p122: 用super操作被隐藏的成员变量和方法
如果在子类中想要使用被子类隐藏的成员变量和方法，需要使用关键字super。
右边的案例中，如果计算resultOne和resultTwo的顺序变成：
float resultTwo = aver.g();
float resultOne = aver.f();
那么输出将是resultTwo:0, resultOne: 50.5，因为子类float f()里的"super.n = n"很关键


p124: super调用父类的构造方法
///
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    int age;

    Student(String name, int age) {
        super(name);        // 调用父类的Person(String name),子类不需要再创建了
                            // 如果又创建一个String name,父类的变量会被隐藏。
        this.age = age;
    }
}
///
所以创建对象可以：Student s = new Student("Tom", 20);
注意：父类没有无参构造方法时，子类必须用 super(参数) 调用父类已有的构造方法。


p125: final关键字可以修饰类，成员变量，方法中的局部变量
final类：final类不能被继承
final方法：用final修饰父类中的一个方法，这个方法不允许被子类重写
final变量：这个变量必须是常量，即必须指定值


p126: 对象的上转型对象
就是用父类类型的变量，指向子类对象。
上转型对象只能访问隐藏的变量，继承的变量，继承或重写的方法。不能使用新增的变量和方法。
多态变量：编译看左边，运行还看左边
多态：编译看左边，运行看右边（如果右边子类有独属于自己的方法，则该对象就用不了）
///
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {          // 重写的方法
        System.out.println("Dog bark");
    }

    void run() {            // 新增的方法
        System.out.println("Dog is running");  
    }
}
///
创建上转型对象：Animal a = new Dog();

注意事项 1：不能直接调用子类独有的方法：
Animal a = new Dog();
a.run();   // 错误

注意事项 2：向下转型前最好用 instanceof：
if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.run();
}

注意事项 3：多态polymorphism意思是同一个父类类型的变量，指向不同子类对象时，调用同一个方法，会表现出不同结果。
///
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog bark");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meow");
    }
}
///
输出为：
///
Animal a1 = new Dog();
Animal a2 = new Cat();

a1.sound();   // Dog bark
a2.sound();   // Cat meow
///
这里a1 a2虽然都是Animal类，且都调用了sound()方法，但是输出不同，这就是多态。


p129: Abstract类和Abstract方法
abstract类不能直接创建对象，但可以有普通方法，abstract方法只能声明，没有具体方法体(操作),具体操作可以交给子类实现：
///
abstract class Animal {
    abstract void sound();

    void sleep() {
        System.out.println("Sleeping");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}
///

1.抽象类不能实例化，不能有对象
2.抽象类中不一定有抽象方法，有时抽象类作用是为了不让外界创建本类对象
3.抽象类中可以有构造方法，目的是为了给成员变量赋值
4.抽象类的子类必须重写父类中全部抽象方法，如果子类也是抽象类，那么允许只重写部分抽象方法，剩下的方法可以交给孙子类来重写

p134: 面向抽象编程
例如现在我需要计算柱体的体积，但是算底面积的getArea根据用户需求不一样，导致会出现三角形底或者圆形底等等。这个时候一个class pillar和class class Circle就不够了。现在需要abstract class Geometry, class Pillar, class Rectangle extends Geometry, class Circle extends Geometry。这就是面向抽象编程。
///
abstract class Geometry {
    abstract double getArea();
}

class Pillar {
    Geometry bottom;        // 用抽象类的bottom
    double height;

    Pillar(Geometry bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    double getVolume() {
        return bottom.getArea() * height;
    }
}

class Circle extends Geometry {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double getArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Geometry {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }
}
///