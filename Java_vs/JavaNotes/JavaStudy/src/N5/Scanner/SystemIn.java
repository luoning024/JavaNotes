package N5.Scanner;
import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入姓名：");
        String name = scanner.nextLine();

        int age;

        while (true) {
            System.out.print("请输入年龄：");

            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // 读走当前行剩余内容和换行

                if (age >= 0 && age <= 150) {
                    break; // 年龄有效，结束检查循环
                }

                System.out.println("年龄必须在0-150岁之间,请重新输入。");

            } else {
                scanner.nextLine(); // 读走错误输入，避免反复检查同一内容
                System.out.println("请输入整数, 例如20.");
            }
        }

        System.out.print("请输入所在城市：");
        String city = scanner.nextLine();

        int nextYearAge = age + 1;

        System.out.printf(
                "%s,你住在%s,明年%d岁。%n",
                name, city, nextYearAge
        );

        scanner.close();
    }
}

