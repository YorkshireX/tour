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


    public PlanInfo(){
        super();
        this.planTime = "";
        this.planPlace = "";
        this.planCard = "";
        this.planCloth = "";
        this.planOther = "";
        this.planMedi = "";
        this.planRain = "";
        this.planSun = "";
    }

    public PlanInfo(String planPlace, String planTime,String planMedi,String planCloth,String planCard,String planSun,String planRain,String planOther){
        super();
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
    public void setPlanTime(String planTime){ this.planTime = planTime;}

    public String getPlanPlace(){
        return planPlace;
    }
    public void setPlanPlace(String planPlace){ this.planPlace = planPlace;}

    public String getPlanCard() { return planCard; }
    public void setPlanCard(String planCard){ this.planCard = planCard;}

    public String getPlanCloth() { return planCloth; }
    public void setPlanCloth(String planCloth){ this.planCloth = planCloth;}

    public String getPlanMedi() { return planMedi; }
    public void setPlanMedi(String planMedi){ this.planMedi = planMedi;}

    public String getPlanOther() { return planOther; }
    public void setPlanOther(String planOther){ this.planOther = planOther;}

    public String getPlanRain() { return planRain; }
    public void setPlanRain(String planRain){ this.planRain = planRain;}

    public String getPlanSun() { return planSun; }
    public void setPlanSun(String planSun){ this.planSun = planSun;}

}
