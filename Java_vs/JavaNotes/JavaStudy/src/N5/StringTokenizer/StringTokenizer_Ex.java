package N5.StringTokenizer;
import java.util.StringTokenizer;

public class StringTokenizer_Ex {
    public static void main(String[] args) {
        
        // p191:StringTokenizer类
        String text = "Java Python C++";

        // 创建分词器，指定空格为分隔符
        StringTokenizer tokens = new StringTokenizer(text, " ");    //" "将分隔符指定为空格

        System.out.println("初始剩余数量：" + tokens.countTokens());
        System.out.println("是否还有 token：" + tokens.hasMoreTokens());

        // 先取出第一个 token
        String first = tokens.nextToken();

        System.out.println("第一个 token：" + first);
        System.out.println("取出后剩余数量：" + tokens.countTokens());

        // 继续取出所有剩余 token
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            System.out.println("本次取出：" + word);
            System.out.println("剩余数量：" + tokens.countTokens());
        }

        System.out.println("是否还有 token：" + tokens.hasMoreTokens());
    }
}
