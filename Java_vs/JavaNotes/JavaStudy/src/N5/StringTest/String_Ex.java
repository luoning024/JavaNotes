package N5.StringTest;

public class String_Ex {
    public static void main(String[] args) {
        // p176: String对象
        String s = new String("We are students.");
        System.out.println(s);


        // p177: 引用String常量
        String hello = "你好";
        String testOne = "你"+"好";
        System.out.println(hello == testOne);   // true
        System.out.println("你好" == testOne);  // true
        System.out.println("你好" == hello);    // true

        String you = "你";
        String hi = "好";
        String testTwo = you + hi;
        System.out.println(hello == testTwo);   // false
        String testThree = you + hi;
        System.out.println(testTwo == testThree);// false


        // p178: String类常用方法

        // 1. public int length()
        String china = "1992 总共有 十个字";
        int n1, n2;
        n1 = china.length();    // 12
        n2 = "小鸟fly".length();// 5
        System.out.println(n1+", "+n2);

        // 2. public boolean equals(String s)
        String s1, s2;
        s1 = new String("We are");
        s2 = new String("We are");
        System.out.println(s1.equals(s2));  // true
        System.out.println(s1 == s2);       // false

        // 4. public int compareTo(String s)
        String s3 = "abcde";
        System.out.println(s3.compareTo("boy"));    // -1
        System.out.println(s3.compareTo("aba"));    // 2
        System.out.println(s3.compareTo("abcde"));  // 0
        System.out.println(" ");

        // 6. public int indexOf(String s), public int lastIndexOf(String s)
        String s4 = "I am a good cat";
        System.out.println("以下展示indexOf用法:");
        System.out.println(s4.indexOf("a"));        // 2
        System.out.println(s4.indexOf("a", 3));     // 5
        System.out.println(s4.lastIndexOf("a"));    // 13

    }
}
