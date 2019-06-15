package cn.edu.swufe.tour;


public class PlaceInfo {

    private String placeAddress;
    private int imageId;
    private String placeName;

    public PlaceInfo(String placeName,String placeAddress,int imageId){
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.imageId = imageId;
    }

    public String getPlaceName(){
        return placeName;
    }

    public String getPlaceAddress(){
        return placeAddress;
    }

    public int getImageId(){
        return imageId;
    }



}
