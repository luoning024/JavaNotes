package N4;
// p163: 接口匿名类例子
interface SpeakHello{
    void speak();
}

class HelloMachine {
    public void turnOn(SpeakHello hello){
        hello.speak();
    }
}

public class Anonymous_Ex{
    public static void main(String[] args) {
        HelloMachine machine = new HelloMachine();
        
        machine.turnOn( new SpeakHello() {      // 与接口SpeakHello有关的匿名类
            public void speak(){
                System.out.println("Hello you are welcome!");
            }
        } 
        );

        machine.turnOn( new SpeakHello() {      // 与接口SpeakHello有关的匿名类
            public void speak(){
                System.out.println("欢迎光临!");
            }
        }
        );
    }
}