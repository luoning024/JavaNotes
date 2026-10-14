import java.util.Scanner;


public class APP01_Ex {
    public static void main(String[] args) {
        Line line = new Line();
        line.givePersonScore();
    }


    public static class InputScore {
        DelScore del;
        InputScore (DelScore del){
            this.del = del;
        }

        public void inputScore(){
            System.out.println("输入评委数：");
            Scanner read = new Scanner(System.in);
            int count = read.nextInt();
            System.out.println("请输入各评委分数：");
            double []a = new double[count];
            for(int i=0;i<count;i++){
                a[i]=read.nextDouble();
            }
            del.doDelete(a);
        }
    }

    public static class DelScore {
        ComputerAver computer;
        DelScore(ComputerAver computer){
            this.computer = computer;
        }
        
        public void doDelete(double[] a){
            java.util.Arrays.sort(a);            //数组a从小到大排序
            System.out.println("去掉一个最高分："+ a[a.length-1]);
            System.out.println("去掉一个最低分："+ a[0]);
            double b[] = new double[a.length-2];
            for (int i=1; i<a.length-1; i++){   //在新数组里去掉最高分和最低分
                b[i-1] = a[i];
            }
            computer.giveAver(b);
        }
    }

    public static class ComputerAver{
        public void giveAver(double [] b){
            double sum=0;
            for (int i=0;i<b.length;i++){
                sum = sum + b[i];
            }
            double aver = sum/b.length;
            System.out.println("选手最后得分"+aver);
        }
    }

    public static class Line{
        InputScore one;
        DelScore two;
        ComputerAver three;
        Line(){
            three = new ComputerAver();
            two = new DelScore(three);
            one = new InputScore(two);
        }
        public void givePersonScore(){
            one.inputScore();
        }
    }
}
