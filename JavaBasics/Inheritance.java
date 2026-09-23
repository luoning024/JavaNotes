package srcs;

public class Inheritance {
    public static class Animal {
        public void eat() {
            System.out.println("Eating");
        }
    }

    public static class Dog extends Animal {

        public void bark() {
            System.out.println("Woof");
        }
    }

    // 继承关系，dog类自动拥有animal类的eat
    public static void main(String[] args) {
        Dog puppy = new Dog();
        puppy.eat();
        puppy.bark();
    }
}
