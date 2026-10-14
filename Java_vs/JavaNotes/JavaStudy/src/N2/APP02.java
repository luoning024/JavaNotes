public class APP02 {
    public static void main(String[] args) {
        
        // p118: 方法重写 override
        B b = new B();
        double result = b.computer(8,9);     // b调用重写的方法
        System.out.println(result);
        int m = b.g(12, 8);                  // b调用继承的方法
        System.out.println(m);

        // p122: 用super操作被隐藏的成员变量和方法
        Average aver = new Average();
        aver.n=100;
        float resultOne = aver.f();
        float resultTwo = aver.g();
        System.out.println("result one is "+ resultOne);    // 5050 / 100 = 50.5
        System.out.println("result two is "+ resultTwo);    // 5050 / 2 = 2525

    }



    // p118: 方法重写 override
    static class A{
        float computer(float x, float y){
            return x/y;
        }
        public int g(int x, int y){
            return x+y;
        }
    }

    static class B extends A{
        float computer(float x, float y){
            return x*y;
        }
    }


    // p122: 用super操作被隐藏的成员变量和方法
    static class Sum{
        int n;

        float f(){
            float sum=0;
            for(int i=0; i<=n; i++){
                sum = sum + i;
            }
            return sum;
        }
    }

    static class Average extends Sum {
        int n;  // 这个n把Sum的成员变量n隐藏了

        float f() {
            float c;
            super.n = n;    // 左边的n是父类的n，右边的是子类的，这里是让父类的n等于传入Average的n。
            c = super.f();  // 调用父类Sum的f()，这里不是在用Average的f()
            return c/n;
        }

        float g(){
            float c;
            c = super.f();  // 依然在调用父类Sum的f()
            return c/2;
        }
    }

}
