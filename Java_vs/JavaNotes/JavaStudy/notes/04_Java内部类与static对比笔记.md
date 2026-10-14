# Java 内部类与 static 对比笔记

以 `APP04 → Student → ScoreViewer` 为例，逐层理解类、对象和 `static`。

## 1. 先分清三个位置的 static

| 位置 | 示例 | 含义 |
| --- | --- | --- |
| 嵌套类 | `static class Student` | 创建 Student 对象时，不需要关联 APP04 对象 |
| 字段 | `static int score` | 字段属于类，所有 Student 对象共享一份成绩 |
| 方法 | `static void show(...)` | 调用方法时，不需要 ScoreViewer 对象；方法内没有当前查看器的 this |

**给类加 static，不会自动给它的字段、方法或更内层的类加 static。**

例如：

```java
static class Student {
    int score = 80;       // 每个学生各有自己的成绩
    class ScoreViewer {  // 仍然是非静态内部类
    }
}
```

严格术语：带 static 的嵌套类叫“静态嵌套类”，不属于内部类。普通顶层类不能加 static；本笔记中的 Student 和 ScoreViewer 都是成员嵌套类。

## 2. 什么叫“关联外部对象”？

非静态成员内部类对象知道自己属于哪一个外部对象。

```java
Student.ScoreViewer viewer = alice.new ScoreViewer();
```

这里 viewer 关联 alice，所以可以直接访问 alice 的实例字段。

它关联的是学生对象，不是创建时的成绩副本：如果 alice 的成绩后来改变，查看器读取的也是新成绩。

静态嵌套类不自动建立这种关联：

```java
Student.ScoreViewer viewer = new Student.ScoreViewer();
```

它没有自动绑定 Alice 或 Bob。如果需要读取某个学生的成绩，必须明确提供该学生，例如传入方法参数或构造器参数。

## 3. 三种类声明的对比

以下创建代码均位于 APP04.main() 中。

| 情况 | Student 声明 | ScoreViewer 声明 | 创建学生 | 创建查看器 |
| --- | --- | --- | --- | --- |
| A：两层都非静态 | `class Student` | `class ScoreViewer` | `app.new Student()` | `alice.new ScoreViewer()` |
| B：只把 Student 改成静态 | `static class Student` | `class ScoreViewer` | `new Student()` | `alice.new ScoreViewer()` |
| C：两层都静态 | `static class Student` | `static class ScoreViewer` | `new Student()` | `new Student.ScoreViewer()` |

**加在哪一层，那一层的对象就不再自动关联它的外部对象。**

> 以下完整示例是 APP04.java 的不同版本。一次只保留一个版本，不要把多个同名 APP04 类一起复制进同一个文件。

## 4. 情况 A：两层都是非静态内部类

```java
public class APP04 {
    public static void main(String[] args) {
        APP04 app = new APP04();

        Student alice = app.new Student();
        Student bob = app.new Student();
        alice.score = 90;
        bob.score = 70;

        Student.ScoreViewer aliceViewer = alice.new ScoreViewer();
        Student.ScoreViewer bobViewer = bob.new ScoreViewer();

        aliceViewer.show(); // 90
        bobViewer.show();   // 70
    }

    class Student {
        int score = 80;

        class ScoreViewer {
            void show() {
                System.out.println(score);
            }
        }
    }
}
```

需要逐层指定对象：

1. `new APP04()`：创建 app。
2. `app.new Student()`：创建关联 app 的学生。
3. `alice.new ScoreViewer()`：创建关联 alice 的查看器。

main 是静态方法，执行它不会自动创建 APP04 对象，所以需要先明确创建 app。

## 5. 情况 B：Student 静态，ScoreViewer 非静态

```java
public class APP04 {
    public static void main(String[] args) {
        Student alice = new Student();
        Student bob = new Student();
        alice.score = 90;
        bob.score = 70;

        Student.ScoreViewer aliceViewer = alice.new ScoreViewer();
        Student.ScoreViewer bobViewer = bob.new ScoreViewer();

        aliceViewer.show(); // 90
        bobViewer.show();   // 70

        alice.score = 100;
        aliceViewer.show(); // 100：读取的是当前成绩
    }

    static class Student {
        int score = 80;

        class ScoreViewer {
            void show() {
                System.out.println(score);
            }
        }
    }
}
```

变化只有一层：Student 不再自动关联 APP04，因此不需要创建 app。

ScoreViewer 仍是非静态内部类，因此仍需要关联某个学生。

这个版本适合表达“每个查看器属于某个学生”。

### 为什么 show() 可以直接使用 score？

ScoreViewer 中没有自己的 score，因此这里访问的是关联学生的 score。也可以明确写成：

```java
System.out.println(Student.this.score);
```

在 ScoreViewer 的实例方法中：

| 写法 | 含义 |
| --- | --- |
| `this` | 当前 ScoreViewer 对象 |
| `Student.this` | 与查看器关联的 Student 对象 |

## 6. 情况 C：Student 和 ScoreViewer 都静态

```java
public class APP04 {
    public static void main(String[] args) {
        Student alice = new Student();
        Student bob = new Student();
        alice.score = 90;
        bob.score = 70;

        Student.ScoreViewer viewer = new Student.ScoreViewer();

        viewer.show(alice); // 90
        viewer.show(bob);   // 70
    }

    static class Student {
        int score = 80;

        static class ScoreViewer {
            void show(Student student) {
                System.out.println(student.score);
            }
        }
    }
}
```

### 为什么这里传参？

`new Student.ScoreViewer()` 没有自动关联某个学生，因此需要告诉它这次查看谁：

```java
viewer.show(alice);
```

- viewer：执行查看操作的对象。
- alice：被查看成绩的学生。
- student：方法中的参数变量，此次指向 alice。

传入的是对象引用，没有复制或创建一个新学生。

**不是“静态类必须传参”，而是“需要实例数据时，必须明确获得对应对象”。**也可以通过构造器保存学生引用；本例用方法参数，是为了让同一个查看器能查看不同学生。

### 为什么 show() 没有 static？

类上的 static 不会自动影响方法。这里 show() 仍然属于查看器对象，因此通过 `viewer.show(...)` 调用。

## 7. 情况 D：再把 show() 改为静态方法

只改情况 C 的方法声明：

```java
static class ScoreViewer {
    static void show(Student student) {
        System.out.println(student.score);
    }
}
```

main 中就可以直接写：

```java
Student.ScoreViewer.show(alice); // 90
Student.ScoreViewer.show(bob);   // 70
```

不需要再创建查看器。它仍然可以访问实例字段，因为参数明确提供了 Student 对象。

**静态方法不能直接使用没有对应对象的实例成员，但可以通过对象访问实例成员。**

## 8. Student.ScoreViewer 中的点号是什么意思？

```java
Student.ScoreViewer aliceViewer = alice.new ScoreViewer();
```

| 部分 | 作用 |
| --- | --- |
| `Student.ScoreViewer` | 类型名称：定义在 Student 内的 ScoreViewer |
| `aliceViewer` | 变量名称 |
| `alice.new ScoreViewer()` | 创建关联 alice 的查看器对象 |

**Student.ScoreViewer 不表示 ScoreViewer 一定是静态类。**无论该类是否带 static，都可以这样表示它的类型。

点号要结合上下文理解：

```java
Student.ScoreViewer       // 类型名称
Student.score            // 通过类名访问静态字段（如果 score 是 static）
alice.score              // 通过对象访问字段
```

变量名也不会建立关联：即使叫 aliceViewer，只要创建方式是 `new Student.ScoreViewer()`，它就不会因此自动关联 alice。

## 9. 不要把 score 也随手改成 static

### 实例字段：每个学生各有一份

```java
int score = 80;
```

```java
alice.score = 90;
bob.score = 70;
// Alice 是 90，Bob 是 70
```

### 静态字段：所有学生共享一份

```java
static int score = 80;
```

Java 允许以下写法，但它容易造成误解：

```java
alice.score = 90;
bob.score = 70;
```

它们实际修改的都是 Student.score，等价于：

```java
Student.score = 90;
Student.score = 70;
// 最后的共享成绩是 70
```

推荐通过类名访问静态字段。

| 声明 | 是否共享 | 是否能重新赋值 |
| --- | --- | --- |
| `int score = 80;` | 不共享，每个对象一份 | 能 |
| `static int score = 80;` | 共享，类一份 | 能 |
| `static final int score = 80;` | 共享，类一份 | 不能 |

static 不表示“不可修改”，final 才限制重新赋值。

## 10. 我遇到过的编译错误

| 写法或问题 | 原因 | 处理方式 |
| --- | --- | --- |
| 在 main 中直接 `new Student()`，但 Student 非静态 | 没有提供 APP04 对象 | `app.new Student()`；若设计不依赖 APP04，也可将 Student 改为静态嵌套类 |
| `new Student.ScoreViewer()`，但 ScoreViewer 非静态 | 没有提供 Student 对象 | `alice.new ScoreViewer()` |
| 静态 ScoreViewer 内直接访问实例字段 score | 没有指定哪个学生 | 获取 Student 对象，再读取 `student.score` |
| 同一作用域先声明 `Student alice`，又声明查看器 alice | 变量名重复 | 查看器改名为 viewer 或 aliceViewer |
| `alice.show()`，但 show 定义在 ScoreViewer 中 | Student 没有这个方法 | 通过查看器对象调用 |
| `viewer.show()`，但方法声明为 `show(Student student)` | 缺少必需参数 | `viewer.show(alice)` |

这些都是编译错误，与程序运行后抛出的异常不同。

## 11. 内存上的区别：先理解对象关系

- 两种类创建的对象通常都分配在堆中；static class 不是“对象放进静态内存”。
- 每次 new 静态嵌套类仍可以创建独立对象，不是只能有一个对象。
- 非静态成员内部类在语言语义上关联外部实例；具体引用字段和占用字节由编译器、JVM 决定，不必死记。
- 如果长期保存的内部类对象持有外部对象引用，外部对象可能无法及时回收。
- 静态嵌套类没有自动关联，但如果代码主动保存外部对象引用，仍可能延长外部对象的生命周期。

## 12. 如何选择？

| 需求 | 选择 |
| --- | --- |
| 查看器创建时就关联某个学生，后续直接读取其成绩 | 非静态 ScoreViewer，使用 `alice.new ScoreViewer()` |
| 查看器独立存在，每次调用可以查看不同学生 | 静态 ScoreViewer，通过参数提供学生 |
| 查看操作不需要查看器自身的实例状态 | 可以考虑静态 show 方法 |
| 每个学生保留自己的成绩 | 非静态 score 字段 |
| 某份数据确实应由整个类共享 | 才考虑静态字段 |

Student 不使用 APP04 的实例状态时，通常可以作为静态嵌套类；若之后要被其他模块广泛复用，也可以单独定义为顶层类。

## 13. 排错时的三个问题

1. 这个成员属于类，还是属于某个对象？
2. 如果属于对象，我现在有没有明确提供这个对象？
3. 加 static 后，改变的对象关系或共享方式是否符合需求？

**不要为了消除报错就加 static。先找到缺少的对象，再决定设计是否需要改变。**

本笔记集中比较成员内部类和静态嵌套类。匿名类是另一种内部类，不能简单套用这里的成员类声明方式。
