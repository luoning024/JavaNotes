package srcs;

public class Encapsulation {
    static class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Ning");
        System.out.println(s.getName());
        s.setName("shit");
        System.out.println(s.getName());
    }
}
