public class APP02_Ex {
    public static void main(String[] args) {
        mobileTelephone telephone = new mobileTelephone();

        SIM sim = new SIMOfChinaMobile();
        sim.setNumber("11223344");
        telephone.useSIM(sim);
        telephone.showMess();

        sim = new SIMOfChinaUnion();
        sim.setNumber("55667788");
        telephone.useSIM(sim);
        telephone.showMess();
    }


    public static abstract class SIM{
        public abstract void setNumber(String n);
        public abstract String giveNumber();
        public abstract String giveCorpName();
    }

    public static class mobileTelephone{
        SIM card;
        public void useSIM (SIM card){
            this.card = card;
        }

        public void showMess(){
            System.out.println("使用的卡是："+card.giveCorpName()+"提供的");
            System.out.println("手机号码是："+ card.giveNumber());
        }
    }

    static class SIMOfChinaMobile extends SIM {
        String number;

        public void setNumber(String n){
            number = n;
        }

        public String giveNumber(){
            return number;
        }

        public String giveCorpName(){
            return "中国移动";
        }
    }

    static class SIMOfChinaUnion extends SIM {
        String number;

        public void setNumber(String n){
            number = n;
        }

        public String giveNumber(){
            return number;
        }

        public String giveCorpName(){
            return "中国联通";
        }
    }

}
