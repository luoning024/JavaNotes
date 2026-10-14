package N4;

// 1. 该例子中的class Student 和 class ScoreViewer都没有static
public class STATICCLASS04 {
    public static void main(String[] args) {

        // printScore();  编译错误,应该先创建对象

        // 由于Student是APP04里面的非static内部类，需要依赖对象
        // 因此需要像下面这样编译，才能创建可用的alice和bob
        APP04 app = new APP04();
        APP04.Student alice = app.new Student();
        APP04.Student bob = app.new Student();

        //如果Student都是非static内部类，那么下面这样编译是错误的
        // Student alice = new Student();
        // Student bob = new Student();

        alice.score = 90;
        bob.score = 70;

        //alice.printScore(); // 90
        //bob.printScore();   // 70    

        Student.ScoreViewer aliceViewer = alice.new ScoreViewer();
        Student.ScoreViewer bobViewer = bob.new ScoreViewer();
        
        aliceViewer.show();
        bobViewer.show();

    }
    
    // 非static内部类
    class Student {
        int score = 80;

        void printScore() {
            System.out.println(score);
        }

        // 加入一个内部类
        // 给每个学生配一个“成绩查看器”
        class ScoreViewer {
            void show() {
                System.out.println(score);
            }
        }
    }

}



// 2. 该例子中的static class Student，但class ScoreViewer没有static
public class APP04 {
    public static void main(String[] args) {
        // 不再需要先创建 APP04 对象
        Student alice = new Student();
        Student bob = new Student();

        alice.score = 90;
        bob.score = 70;

        // ScoreViewer 仍是非静态内部类，需要关联某个学生
        Student.ScoreViewer aliceViewer =
                alice.new ScoreViewer();

        Student.ScoreViewer bobViewer =
                bob.new ScoreViewer();

        aliceViewer.show(); // 90
        bobViewer.show();   // 70
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



// 3. 该例子中的static class Student，且static class ScoreViewer
public class APP04 {
    public static void main(String[] args) {
        Student alice = new Student();
        Student bob = new Student();

        alice.score = 90;
        bob.score = 70;

        Student.ScoreViewer viewer =
                new Student.ScoreViewer();

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