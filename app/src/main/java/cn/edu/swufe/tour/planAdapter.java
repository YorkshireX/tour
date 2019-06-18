package cn.edu.swufe.tour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static android.content.Intent.getIntent;
import static android.support.constraint.Constraints.TAG;

public class planAdapter extends BaseAdapter {
    private Context context;
    HashMap<Integer, String> saveMap;//这个集合用来存储对应位置上Editext中的文本内容


    public planAdapter(Context context){
        super();
        this.context = context;
        saveMap = new HashMap<Integer, String>();
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh= null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = View.inflate(context, R.layout.activity_plan_item, null);
            vh.et_plan_place = (EditText) convertView.findViewById(R.id.et_plan_place);
            vh.et_plan_time = (EditText) convertView.findViewById(R.id.et_plan_time);
            vh.et_plan_medi = (EditText) convertView.findViewById(R.id.et_plan_medi);
            vh.et_plan_cloth = (EditText) convertView.findViewById(R.id.et_plan_cloth);
            vh.et_plan_card = (EditText) convertView.findViewById(R.id.et_plan_card);
            vh.et_plan_sun = (EditText) convertView.findViewById(R.id.et_plan_sun);
            vh.et_plan_rain = (EditText) convertView.findViewById(R.id.et_plan_rain);
            vh.et_plan_other = (EditText) convertView.findViewById(R.id.et_plan_other);

            vh.tv_plan_place = (TextView) convertView.findViewById(R.id.tv_plan_place);
            vh.tv_plan_time = (TextView) convertView.findViewById(R.id.tv_plan_time);
            vh.tv_plan_card = (TextView) convertView.findViewById(R.id.tv_plan_card);
            vh.tv_plan_care = (TextView) convertView.findViewById(R.id.tv_plan_care);
            vh.tv_plan_cloth = (TextView) convertView.findViewById(R.id.tv_plan_cloth);
            vh.tv_plan_medi = (TextView) convertView.findViewById(R.id.tv_plan_medi);
            vh.tv_plan_rain = (TextView) convertView.findViewById(R.id.tv_plan_rain);
            vh.tv_plan_sun = (TextView) convertView.findViewById(R.id.tv_plan_sun);
            vh.tv_plan_other = (TextView) convertView.findViewById(R.id.tv_plan_other);
            vh.tv_plann = (TextView) convertView.findViewById(R.id.tv_plann);


            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.tv_plann.setText("计划" + position);
        vh.et_plan_place.setTag(position);//设置editext一个标记
        vh.et_plan_time.setTag(position);//设置editext一个标记
        vh.et_plan_rain.setTag(position);//设置editext一个标记
        vh.et_plan_medi.setTag(position);//设置editext一个标记
        vh.et_plan_sun.setTag(position);//设置editext一个标记
        vh.et_plan_cloth.setTag(position);//设置editext一个标记
        vh.et_plan_card.setTag(position);//设置editext一个标记
        vh.et_plan_other.setTag(position);//设置editext一个标记

        vh.et_plan_place.clearFocus();//清除焦点  不清除的话因为item复用的原因   多个Editext同时改变
        vh.et_plan_place.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_card.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_cloth.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_medi.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_other.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_time.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_sun.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        vh.et_plan_rain.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去


        final EditText tempEditText=vh.et_plan_place;
        vh.et_plan_place.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                Integer tag= (Integer) tempEditText.getTag();
                saveMap.put(tag, s.toString());//在这里根据position去保存文本内容
            }
        });
        Log.e("TAG", saveMap.toString());
        return convertView;
    }

    public class ViewHolder {
        EditText et_plan_place;
        EditText et_plan_time;
        EditText et_plan_medi;
        EditText et_plan_card;
        EditText et_plan_sun;
        EditText et_plan_cloth;
        EditText et_plan_rain;
        EditText et_plan_other;

        TextView tv_plan_place;
        TextView tv_plan_time;
        TextView tv_plan_card;
        TextView tv_plan_care;
        TextView tv_plan_cloth;
        TextView tv_plan_medi;
        TextView tv_plan_rain;
        TextView tv_plan_sun;
        TextView tv_plan_other;
        TextView tv_plann;




    }

   /* @Override
    public View getView(int position, View convertView, ViewGroup parent){
        PlanInfo planInfo=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView planPlace=(TextView) view.findViewById(R.id.plan_place);
        TextView planTime=(TextView) view.findViewById(R.id.plan_time);
        TextView planMedi=(TextView) view.findViewById(R.id.plan_medi);
        TextView planCloth=(TextView) view.findViewById(R.id.plan_cloth);
        TextView planCard=(TextView) view.findViewById(R.id.plan_card);
        TextView planSun=(TextView) view.findViewById(R.id.plan_sun);
        TextView planRain=(TextView) view.findViewById(R.id.plan_rain);
        TextView planOther=(TextView) view.findViewById(R.id.plan_other);

        planPlace.setText(planInfo.getPlanTime());
        planTime.setText(planInfo.getPlanTime());
        planMedi.setText(planInfo.getPlanMedi());
        planCloth.setText(planInfo.getPlanCloth());
        planCard.setText(planInfo.getPlanCard());
        planRain.setText(planInfo.getPlanRain());
        planSun.setText(planInfo.getPlanSun());
        planOther.setText(planInfo.getPlanOther());

        return view;
    }*/

}
