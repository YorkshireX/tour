package cn.edu.swufe.tour;

public class GuZhenItem {
    private int id;
    private String gzPlace;
    private String gzTime;
    private String gzRoute;
    private String gzTicket;
    private String gzMedi;
    private String gzCloth;
    private String gzCard;
    private String gzSun;
    private String gzRain;
    private String gzOther;



    public GuZhenItem() {
        super();
        gzPlace = "";
        gzTime = "";
        gzRoute = "";
        gzTicket = "";
        gzMedi = "";
        gzCloth = "";
        gzCard = "";
        gzSun = "";
        gzRain = "";
        gzOther = "";

    }
    public GuZhenItem(String gzPlace, String gzTime,String gzRoute, String gzTicket,String gzMedi
    ,String gzCloth,String gzCard,String gzSun,String gzRain,String gzOther) {
        super();
        this.gzPlace = gzPlace;
        this.gzTime = gzTime;
        this.gzRoute = gzRoute;
        this.gzTicket = gzTicket;
        this.gzMedi = gzMedi;
        this.gzCloth = gzCloth;
        this.gzCard = gzCard;
        this.gzSun = gzSun;
        this.gzRain = gzRain;
        this.gzOther = gzOther;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGzPlace() {
        return gzPlace;
    }
    public void setGzPlace(String gzPlace) {
        this.gzPlace = gzPlace;
    }
    public String getGzTime() {
        return gzTime;
    }
    public void setGzTime(String gzTime) {
        this.gzTime = gzTime;
    }
    public String getGzRoute() {
        return gzTime;
    }
    public void setGzRoute(String gzRoute) {
        this.gzRoute = gzRoute;
    }
    public String getGzTicket() {
        return gzTicket;
    }
    public void setGzTicket(String gzTicket) {
        this.gzTicket = gzTicket;
    }
    public String getGzMedi() {
        return gzMedi;
    }
    public void setGzMedi(String gzMedi) {
        this.gzMedi = gzMedi;
    }
    public String getGzCloth() {
        return gzCloth;
    }
    public void setGzCloth(String gzCloth) {
        this.gzCloth = gzCloth;
    }
    public String getGzCard() {
        return gzCard;
    }
    public void setGzCard(String gzCard) {
        this.gzCard = gzCard;
    }
    public String getGzSun() {
        return gzSun;
    }
    public void setGzSun(String gzSun) {
        this.gzSun = gzSun;
    }
    public String getGzRain() {
        return gzRain;
    }
    public void setGzRain(String gzRain) {
        this.gzRain = gzRain;
    }
    public String getGzOther() {
        return gzOther;
    }
    public void setGzOther(String gzOther) {
        this.gzSun = gzOther;
    }
}
