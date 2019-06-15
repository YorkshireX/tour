package cn.edu.swufe.tour;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class plan extends ListActivity implements AdapterView.OnItemClickListener {
    private ArrayList<HashMap<String, String>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器
    private int msgWhat = 7;
    Handler handler;
    public final String TAG = "plan";
    private ImageButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_plan);

        initListView();
        this.setListAdapter(listItemAdapter);

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        List<Map<String,Object>> planlist = new ArrayList<Map<String,Object>>();

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent addplan=new Intent(plan.this,addPlan.class);
                startActivity(addplan);
            }
        });


        Intent intent = getIntent();
        String place = intent.getStringExtra("plan_place");
        String time = intent.getStringExtra("plan_time");
        String other = intent.getStringExtra("plan_other");
        String medi = intent.getStringExtra("plan_medi");
        String cloth = intent.getStringExtra("plan_cloth");
        String card = intent.getStringExtra("plan_card");
        String sun = intent.getStringExtra("plan_sun");
        String rain = intent.getStringExtra("plan_rain");

        Log.i(TAG,"onCreate: place=" + place);
        Log.i(TAG,"onCreate: time=" + time);
        Log.i(TAG,"onCreate: other=" + other);
        Log.i(TAG,"onCreate: medi=" + medi);
        Log.i(TAG,"onCreate: cloth=" + cloth);
        Log.i(TAG,"onCreate: card=" + card);
        Log.i(TAG,"onCreate: sun=" + sun);
        Log.i(TAG,"onCreate: rain=" + rain);

        getListView().setOnItemClickListener(this);

    }

    public void openAddPlan(View btn){
        Log.i("open","openAddPlan");
        openAddPlan();
    }
    private void openAddPlan(){
        Intent addPlan = new Intent(this,addPlan.class);
        startActivity(addPlan);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(TAG, "onItemClick: parent=" + parent);
        Log.i(TAG, "onItemClick: view=" + view);
        Log.i(TAG, "onItemClick: position=" + position);
        Log.i(TAG, "onItemClick: id=" + id);

        //从ListView中获取选中数据
        HashMap<String,String> map = (HashMap<String, String>) getListView().getItemAtPosition(position);
        String titleStr = map.get("ItemTitle");
        String detailStr = map.get("ItemDetail");
        Log.i(TAG, "onItemClick: titleStr=" + titleStr);
        Log.i(TAG, "onItemClick: detailStr=" + detailStr);

        //从View中获取选中数据
        TextView title = (TextView) view.findViewById(R.id.et_plan_time);
        TextView detail = (TextView) view.findViewById(R.id.et_plan_place);
        String title2 = String.valueOf(title.getText());
        String detail2 = String.valueOf(detail.getText());
        Log.i(TAG, "onItemClick: title2=" + title2);
        Log.i(TAG, "onItemClick: detail2=" + detail2);

        //打开新的页面，传入参数
        Intent planList = new Intent(this,addPlan.class);
        planList.putExtra("time",titleStr);
        planList.putExtra("place",detailStr);
        startActivity(planList);
    }

    private void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map = new HashMap<String, String>();
            //map.put("ItemTime", "时间： " + ); // 标题文字
            //map.put("ItemPlace", "景区：" + ); // 详情描述
            listItems.add(map);

        // 生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                R.layout.activity_plan_item, // ListItem的XML布局实现
                new String[] { "ItemTime", "ItemPlace" },
                new int[] { R.id.itemTime, R.id.itemPlace }
        );
    }
}
