package N5.StringTest;
import java.util.*;

public class SortString_Ex {
    public static void main(String[] args) {
        String [] a = {"melon", "apple", "pear", "banana"};
        String [] b = {"西瓜", "苹果", "梨", "香蕉"};

        System.out.println("使用SortString排序数组a:");
        SortString.sort(a);
        for (int i=0; i<a.length; i++){
            System.out.println(" " + a[i]);
        }

        System.out.println(" ");

        System.out.println("使用类库中的Array类，按字典顺序排列数组b:");
        Arrays.sort(b);
        for (int i=0; i<b.length; i++){
            System.out.println(" " + b[i]);
        }
    }
}
