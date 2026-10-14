package N4;

// p162 内部类书中例子
// RedCowForm类里有一个RedCow内部类

public class RedCowF_Ex{
    public static void main(String[] args) {
        RedCowForm form = new RedCowForm("红牛农场");
        form.showCowMess();
        // form.cow.mow();
        
        RedCowForm.RedCow hn = new RedCowForm.RedCow(123, 112, 999);
        hn.mow();
    }
}