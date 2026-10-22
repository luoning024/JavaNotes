package N5.Scanner;
import java.util.*;

public class GetPrice {
    public static double givePriceSum(String cost){
        Scanner scanner = new Scanner(cost);
        scanner.useDelimiter("[^0123456789.]+");
        double sum = 0;
        while(scanner.hasNext()){
            try {
                double price = scanner.nextDouble();
                sum = sum + price;
            }
            catch(InputMismatchException exp){
                String t = scanner.next();
            }
        }
        return sum;
    }
}
