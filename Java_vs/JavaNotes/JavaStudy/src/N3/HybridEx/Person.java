package N3.HybridEx;

// 这个类也被定义为抽象类是因为不想让外界创建该类的对象

public abstract class Person {
    private String name;
    private int age;

    public Person(){}

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
