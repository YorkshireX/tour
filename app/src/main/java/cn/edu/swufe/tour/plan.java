package cn.edu.swufe.tour;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class plan extends AppCompatActivity implements View.OnClickListener {

    private String TAG = this.getClass().getSimpleName();
    //装在所有动态添加的Item的LinearLayout容器
    private LinearLayout addPlanNameView;

  /*  public final String TAG = "plan";
    private ImageButton add;
    private List<PlanInfo> planList=new ArrayList<>();
    private ListView planlist;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        addPlanNameView = (LinearLayout) findViewById(R.id.ll_addViewPlan);
        findViewById(R.id.btn_getDataPlan).setOnClickListener(this);

        //默认添加一个Item
        addViewItemPlan(null);
    }

        //initPlanInfo();
        //planAdapter adapter=new planAdapter(plan.this,R.layout.activity_plan_item,planList);


        //ListView list_plan = (ListView) findViewById(R.id.planlist);
        //list_plan.setAdapter(adapter);

        /* add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(plan.this,addPlan.class);
                startActivityForResult(intent,1);
            }
        });

        ListView myplan = (ListView) findViewById(R.id.planlist);
        planAdapter myAdapter = new planAdapter(this);
        myplan.setAdapter(myAdapter);


    }

    /** private void initPlanInfo() {
        for(int i=0;i<2;i++){
            TextView plantime = findViewById(R.id.plan_time);
            TextView planplace = findViewById(R.id.plan_place);
            TextView planmedi = findViewById(R.id.plan_medi);
            TextView plancloth = findViewById(R.id.plan_cloth);
            TextView plancard = findViewById(R.id.plan_card);
            TextView plansun = findViewById(R.id.plan_sun);
            TextView planrain = findViewById(R.id.plan_rain);
            TextView planother = findViewById(R.id.plan_other);


            String pt = plantime.getText().toString();
            String pp = planplace.getText().toString();
            String pm = planmedi.getText().toString();
            String pca = plancard.getText().toString();
            String pcl = plancloth.getText().toString();
            String po = planother.getText().toString();
            String pr = planrain.getText().toString();
            String ps = plansun.getText().toString();


            PlanInfo newPlan = new PlanInfo(pp,pt,pm,pcl,pca,ps,pr,po);
            planList.add(newPlan);
        }
    }**/

    /* public void openAddPlan(View btn){
        Log.i("open","openAddPlan");
        openAddPlan();
    }
    private void openAddPlan(){
        Intent addPlan = new Intent(this,addPlan.class);
        startActivity(addPlan);
    }

    */


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addPlan://点击添加按钮就动态添加Item
                addViewItemPlan(v);
                break;
            case R.id.btn_getDataPlan://打印数据
                printDataPlan();
                break;
        }

    }

    private void sortPlanViewItem() {
        //获取LinearLayout里面所有的view
        for (int i = 0; i < addPlanNameView.getChildCount(); i++) {
            final View childAt = addPlanNameView.getChildAt(i);
            final Button btn_remove = (Button) childAt.findViewById(R.id.btn_addPlan);
            btn_remove.setText("删除");
            btn_remove.setTag("remove");//设置删除标记
            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //从LinearLayout容器中删除当前点击到的ViewItem
                    addPlanNameView.removeView(childAt);
                }
            });
            //如果是最后一个ViewItem，就设置为添加
            if (i == (addPlanNameView.getChildCount() - 1)) {
                Button btn_add = (Button) childAt.findViewById(R.id.btn_addPlan);
                btn_add.setText("+添加");
                btn_add.setTag("add");
                btn_add.setOnClickListener(this);
            }
        }
    }

    //添加ViewItem
    private void addViewItemPlan(View view) {
        if (addPlanNameView.getChildCount() == 0) {//如果一个都没有，就添加一个
            View planView = View.inflate(this, R.layout.activity_place_item, null);
            Button btn_add = (Button) planView.findViewById(R.id.btn_addPlan);
            btn_add.setText("+添加");
            btn_add.setTag("add");
            btn_add.setOnClickListener(this);
            addPlanNameView.addView(planView);
            //sortTieziViewItem();
        } else if (((String) view.getTag()).equals("add")) {//如果有一个以上的Item,点击为添加的Item则添加
            View planView = View.inflate(this, R.layout.activity_plan_item, null);
            addPlanNameView.addView(planView);
            sortPlanViewItem();
        }
        //else {
        //  sortTieziViewItem();
        //}
    }

    private void printDataPlan() {
        for (int i = 0; i < addPlanNameView.getChildCount(); i++) {
            View childAt = addPlanNameView.getChildAt(i);
            EditText planPlace = (EditText) childAt.findViewById(R.id.et_plan_place);
            EditText planTime = (EditText) childAt.findViewById(R.id.et_plan_time);
            EditText planCloth = (EditText) childAt.findViewById(R.id.et_plan_cloth);
            EditText planCard = (EditText) childAt.findViewById(R.id.et_plan_card);
            EditText planSun = (EditText) childAt.findViewById(R.id.et_plan_sun);
            EditText planRain = (EditText) childAt.findViewById(R.id.et_plan_rain);
            EditText planOther = (EditText) childAt.findViewById(R.id.et_plan_other);

            planPlace.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planPlace.setGravity(Gravity.TOP);
            planPlace.setSingleLine(false);
            planPlace.setHorizontallyScrolling(false);

            planTime.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planTime.setGravity(Gravity.TOP);
            planTime.setSingleLine(false);
            planTime.setHorizontallyScrolling(false);

            planCloth.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planCloth.setGravity(Gravity.TOP);
            planCloth.setSingleLine(false);
            planCloth.setHorizontallyScrolling(false);

            planCard.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planCard.setGravity(Gravity.TOP);
            planCard.setSingleLine(false);
            planCard.setHorizontallyScrolling(false);

            planCard.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planCard.setGravity(Gravity.TOP);
            planCard.setSingleLine(false);
            planCard.setHorizontallyScrolling(false);

            planSun.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planSun.setGravity(Gravity.TOP);
            planSun.setSingleLine(false);
            planSun.setHorizontallyScrolling(false);

            planRain.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planRain.setGravity(Gravity.TOP);
            planRain.setSingleLine(false);
            planRain.setHorizontallyScrolling(false);

            planOther.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            planOther.setGravity(Gravity.TOP);
            planOther.setSingleLine(false);
            planOther.setHorizontallyScrolling(false);

            Log.e(TAG, "景区：" + planPlace.getText().toString() + "-----时间："
                    + planTime.getText().toString());
        }
    }
}
