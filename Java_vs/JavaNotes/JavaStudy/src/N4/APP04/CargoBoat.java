package N4.APP04;

public class CargoBoat {
    int realContent;    //装载重量
    int maxContent;     // 最大重量

    public void setMaxContent(int c){
        maxContent=c;
    }

    public void loading (int m) throws DangerException{
        realContent += m;
        if(realContent>maxContent){
            realContent -= m;
            throw new DangerException();
        }
        System.out.println("目前装载了"+realContent+"吨货物");
    }
}
