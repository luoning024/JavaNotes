package N5.StringTokenizer;
import java.util.*;

public class PriceToken {
    public double getPriceSum(String shoppingReceipt){
        String regex = "[^0123456789.]+";   // 匹配非数字字符序列，连续出现的、既不是数字也不是小数点的字符
        shoppingReceipt = shoppingReceipt.replaceAll(regex, "#");   // 把所有符合规则的字符序列替换为 "#"

        StringTokenizer fenxi = new StringTokenizer(shoppingReceipt, "#");
        double sum = 0;
        while(fenxi.hasMoreTokens()){
            String word = fenxi.nextToken();
            double price = Double.parseDouble(word);    // 将字符串转换为 double
            sum = sum + price;
        }
        return sum;
    }

    public double getAverPrice(String shoppingReceipt){
        double priceSum = getPriceSum(shoppingReceipt);
        int goodsAmount = getGoodsAmount(shoppingReceipt);
        return priceSum/goodsAmount;
    }

    public int getGoodsAmount(String shoppingReceipt){
        String regex = "[^0123456789.]+";
        shoppingReceipt = shoppingReceipt.replaceAll(regex, "#");
        StringTokenizer fenxi = new StringTokenizer(shoppingReceipt, "#");

        int amount = fenxi.countTokens();
        return amount;
    }

}
