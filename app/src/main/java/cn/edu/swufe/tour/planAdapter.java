package cn.edu.swufe.tour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class planAdapter extends ArrayAdapter<PlanInfo> {

    private int resourceId;
    public planAdapter(Context context, int textViewResourceId, List<PlanInfo> planInfos){
        super(context,textViewResourceId,planInfos);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        PlanInfo planInfo=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView planPlace=(TextView) view.findViewById(R.id.planPlace);
        TextView planTime=(TextView) view.findViewById(R.id.planTime);
        planPlace.setText(planInfo.getPlanTime());
        planTime.setText(planInfo.getPlanTime());

        return view;
    }
}
