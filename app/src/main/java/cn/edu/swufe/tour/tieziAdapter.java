package cn.edu.swufe.tour;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class tieziAdapter extends BaseAdapter {

    private Context context;

    HashMap<Integer, String> saveMap;//这个集合用来存储对应位置上Editext中的文本内容

    public tieziAdapter(Context context){
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
        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = View.inflate(context, R.layout.activity_tiezi_item, null);
            vh.et_tiezi = (EditText) convertView.findViewById(R.id.et_tiezi);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.et_tiezi.setTag(position);//设置editext一个标记
        vh.et_tiezi.clearFocus();//清除焦点  不清除的话因为item复用的原因   多个Editext同时改变
        vh.et_tiezi.setText(saveMap.get(position));//将对应保存在集合中的文本内容取出来  并显示上去
        final EditText tempEditText=vh.et_tiezi;
        vh.et_tiezi.addTextChangedListener(new TextWatcher() {
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
        EditText et_tiezi;
    }


}

