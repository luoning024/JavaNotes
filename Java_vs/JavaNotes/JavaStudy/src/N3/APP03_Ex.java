public class APP03_Ex {
    public static void main(String[] args) {
        AdvertisementBoard board = new AdvertisementBoard();
        board.show(new WhiteCloudCorp());
        board.show(new BlackLandCorp());
    }

    public interface Advertisement {    // 接口
        public void showAdvertisement();
        public String getCorpName();
    }

    public static class AdvertisementBoard {
        public void show(Advertisement adver){
            System.out.println(adver.getCorpName()+"广告词如下：");
            adver.showAdvertisement();      // 接口回调
        }
    }

    public static class WhiteCloudCorp implements Advertisement{
        public void showAdvertisement(){
            System.out.println("###########");
            System.out.println("飞机中的战斗机，哦耶");
            System.out.println("###########\n");
        }

        public String getCorpName(){
            return "白云有限公司";
        }
    }

    public static class BlackLandCorp implements Advertisement{
        public void showAdvertisement(){
            System.out.println("$$$$$$$$$$$$$$");
            System.out.println("感谢TV，感谢所有TV");
            System.out.println("$$$$$$$$$$$$$$\n");
        }

        public String getCorpName(){
            return "黑土集团";
        }
    }
}
