package cn.edu.swufe.tour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class tieziAdapter extends ArrayAdapter<TieziInfo> {
    private int resourceId;
    public tieziAdapter(Context context, int textViewResourceId, List<TieziInfo> tieziInfos){
        super(context,textViewResourceId,tieziInfos);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TieziInfo tieziInfo=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView ttz=(TextView) view.findViewById(R.id.tv_tz);
        ttz.setText(tieziInfo.getTz());

        return view;
    }

}
