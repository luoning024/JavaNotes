package srcs;

public class methodOverride {
    // 父类
    static class Animal {
        public void makeSound() {
            System.out.println("Animal sound");
        }
    }

    // 子类
    static class Dog extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Woof");
        }
    }

    public static void main(String[] args) {

        // 多态：父类引用指向子类对象
        Animal animal = new Dog();

        animal.makeSound();
    }
}
