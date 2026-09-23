package srcs;
import java.util.ArrayList;

public class day1_Basics {
    public static void main(String[] args) {

//        //变量
//        int age = 20;
//        double gpa = 3.8;
//        boolean passed = true;
//        char grade = 'A';
//        String name = "Tom";
//
//        // 运算符
//        if (age >= 18 && gpa > 3.0) {
//            System.out.println("Eligible");
//        }
//
//        // 顺序 分支 循环
//        int score = 85;
//        if (score > 90) {
//            System.out.println("A");
//        } else if (score >= 80) {
//            System.out.println("B");
//        } else {
//            System.out.println("C");
//        }
//
//        for (int i= 5; i<5; i++){
//            System.out.println(i);
//        }
//
//        int k = 0;
//        while (k < 5) {
//            System.out.println(k);
//            k++;
//        }

        // 数组 Array
        int[] numbers = {10,20,30};
        System.out.println(numbers[1]);

//        // 遍历
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
//        // 高级遍历 for-each
//        for (int number : numbers) {
//            System.out.println(number);
//        }

//        // 字符串
//        String name = "Alice";
//        // 方法
//        System.out.println(name.length());
//        name.toUpperCase();
//        name.toLowerCase();
//        name.substring(0, 3);
//        name.charAt(0);
//        // 比较字符串的方法
//        boolean alice = name.equals("Alice");

        ArrayList<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Ning");

        System.out.println(names.get(0));
        names.remove(3);
        System.out.println(names.size());
    }
}
