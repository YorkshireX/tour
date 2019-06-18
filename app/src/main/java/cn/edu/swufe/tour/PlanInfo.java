package cn.edu.swufe.tour;

public class PlanInfo {

    private String planTime;
    private String planPlace;
    private String planMedi;
    private String planRain;
    private String planSun;
    private String planCard;
    private String planCloth;
    private String planOther;



    public PlanInfo(String planPlace, String planTime,String planMedi,String planCloth,String planCard,String planSun,String planRain,String planOther){
        this.planTime = planTime;
        this.planPlace = planPlace;
        this.planCard = planCard;
        this.planCloth = planCloth;
        this.planOther = planOther;
        this.planMedi = planMedi;
        this.planRain = planRain;
        this.planSun = planSun;
    }

    public String getPlanTime(){
        return planTime;
    }

    public String getPlanPlace(){
        return planPlace;
    }

    public String getPlanCard() { return planCard; }

    public String getPlanCloth() { return planCloth; }

    public String getPlanMedi() { return planMedi; }

    public String getPlanOther() { return planOther; }

    public String getPlanRain() { return planRain; }

    public String getPlanSun() { return planSun; }
}
