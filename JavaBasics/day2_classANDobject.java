package srcs;

public class day2_classANDobject {
    static class Student {

        String name;
        int age;

        void study() {
            System.out.println(name + " is studying.");
        }
    }

        public static void main(String[] args) {
            Student s1 = new Student();
            s1.name = "Alice";
            s1.age = 20;

            s1.study();
        }
}

////构造函数
//public class Student {
//
//    String name;
//    int age;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//}
//
//Student s1 = new Student("Alice", 20);
