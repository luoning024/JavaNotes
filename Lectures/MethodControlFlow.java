package Lectures;

public class MethodControlFlow {

    public static void main(String[] args) {
        // methods
        printMyName("Yining", "Luo");
        String A = makeFullName("Loppy", "Shit", false);
        String B = makeFullName("应用", "技术", true);
        System.out.println(A);
        System.out.println(B);


        // control flow
        // if else
        int length = 80;
        if (length < 10) {
            System.out.println("you are Too short");
        } else if (length > 10){
            System.out.println("you are so BIG");
        }
        else if (length >20){
            System.out.println("Shit!");
        }
    }

    public static void printMyName(String firstName, String lastName) {
        System.out.println("My name is "+ firstName + " " + lastName + ".");
    }

    public static String makeFullName (String firstName, String lastName, boolean isChinese){
        return isChinese ? lastName + firstName : firstName + " " + lastName;
    }
}
