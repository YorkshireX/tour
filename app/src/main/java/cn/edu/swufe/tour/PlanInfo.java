package cn.edu.swufe.tour;

public class PlanInfo {

    private String planTime;
    private String planPlace;

    public PlanInfo(String planTime, String planPlace){
        this.planTime = planTime;
        this.planPlace = planPlace;
    }

    public String getPlanTime(){
        return planTime;
    }

    public String getPlanPlace(){
        return planPlace;
    }
}
