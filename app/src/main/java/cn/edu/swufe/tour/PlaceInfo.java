package cn.edu.swufe.tour;


public class  PlaceInfo {

    private String placeMessage;
    private int imageId;
    private String placeName;

    public PlaceInfo(String placeName,String placeMessage,int imageId){
        this.placeName = placeName;
        this.placeMessage = placeMessage;
        this.imageId = imageId;
    }

    public String getPlaceName(){
        return placeName;
    }

    public String getPlaceMessage(){
        return placeMessage;
    }

    public int getImageId(){
        return imageId;
    }



}
