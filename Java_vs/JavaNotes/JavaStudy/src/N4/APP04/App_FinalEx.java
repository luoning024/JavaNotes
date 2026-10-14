package N4.APP04;

public class App_FinalEx {
    public static void main(String[] args) {
        CargoBoat ship = new CargoBoat();
        ship.setMaxContent(1000);
        int m = 600;

        try{
            ship.loading(m);
            m=400;
            ship.loading(m);
            m=367;
            ship.loading(m);
            m=555;
            ship.loading(m);
        }
        catch (DangerException e){
            System.out.println(e.wardMess());
            System.out.println("无法装载重量为"+ m +"吨的箱子");
        }
        finally{
            System.out.println("出发！");
        }
    }
}
