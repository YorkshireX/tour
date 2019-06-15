package cn.edu.swufe.tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class placeAdapter extends ArrayAdapter<PlaceInfo> {
    private int resourceId;
    public placeAdapter(Context context, int textViewResourceId, List<PlaceInfo> placeInfos){
        super(context,textViewResourceId,placeInfos);
        resourceId=textViewResourceId;
    }
     @Override
      public View getView(int position, View convertView, ViewGroup parent){
        PlaceInfo placeInfo=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView placeImage=(ImageView)view.findViewById(R.id.place_image);
        TextView placeName=(TextView) view.findViewById(R.id.place_name);
        TextView placeAddress=(TextView) view.findViewById(R.id.place_address);
        placeImage.setImageResource(placeInfo.getImageId());
        placeName.setText(placeInfo.getPlaceName());
        placeAddress.setText(placeInfo.getPlaceAddress());

        return view;
    }

}
