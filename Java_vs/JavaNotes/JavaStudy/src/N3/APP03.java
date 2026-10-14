public class APP03 {
    public static void main(String[] args) {
        // p146: 重写接口中的方法
        China zhang;
        Japan henlu;
        zhang=new China();
        henlu=new Japan();
        zhang.number = 32+Computable.MAX;   // 用接口名访问接口常量
        henlu.number = 14+Computable.MAX; 
        System.out.println("zhang的学号"+zhang.number+" zhang的求和："+zhang.f(100));
        System.out.println("henlu的学号"+henlu.number+" henlu的求和："+henlu.f(100));


        // p151:接口回调与理解接口
        Bus bus101 = new Bus();
        Taxi greenTaxi = new Taxi();
        Cinema shangkCinema = new Cinema();
        Moneyfare fare;
        ControlTemperature temp;

        fare=bus101;
        bus101.brake();
        fare.charge();

        fare=greenTaxi;
        temp=greenTaxi;
        greenTaxi.brake();
        fare.charge();
        temp.controlAirTemperature();

        fare=shangkCinema;
        temp=shangkCinema;
        fare.charge();
        temp.controlAirTemperature();

    }



    // p146: 重写接口中的方法
    public interface Computable {
        int MAX = 46;
        int f(int x);
    }

    public static class China implements Computable{   //China类实现computable接口
        int number;
        public int f(int x){       // 不能忘记public关键字
            int sum=0;
            for(int i=1;i<=x;i++){
                sum = sum+i;
            }
            return sum;
        }
    }

    public static class Japan implements Computable{   
        int number;
        public int f(int x){        // 不能忘记public关键字
            return MAX+x;           // 用接口名访问接口的常量
        }   
    }


    // p151:接口回调与理解接口
    static abstract class MotorVehicles{
        abstract void brake();
    }

    interface Moneyfare{
        void charge();
    }

    interface ControlTemperature{
        void controlAirTemperature();
    }

    static class Bus extends MotorVehicles implements Moneyfare {
        void brake(){
            System.out.println("Bus使用四个轮子同时刹车。");
        }

        public void charge(){
            System.out.println("Bus收费为一元一个人。");
        }
    }

    static class Taxi extends MotorVehicles implements Moneyfare, ControlTemperature {
        void brake(){
            System.out.println("Taxi可以使用两个轮子同时刹车。");
        }

        public void charge(){
            System.out.println("Taxi收费为按实际公里数计算。");
        }

        public void controlAirTemperature(){
            System.out.println("Taxi安装了空调。");
        }
    }

    static class Cinema implements Moneyfare, ControlTemperature {
        public void charge(){
            System.out.println("电影院门票是二十元一个人。");
        }

        public void controlAirTemperature(){
            System.out.println("电影院安装了中央大空调。");
        }
    }

}
