package cn.edu.swufe.tour;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class plan extends AppCompatActivity{

    public final String TAG = "plan";
    private ImageButton add;
    private List<PlanInfo> planList=new ArrayList<>();
    private ListView planlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        //initPlanInfo();
        //planAdapter adapter=new planAdapter(plan.this,R.layout.activity_plan_item,planList);


        //ListView list_plan = (ListView) findViewById(R.id.planlist);
        //list_plan.setAdapter(adapter);

        add = findViewById(R.id.add);
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

    /*private void initPlanInfo() {
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
    }*/

    public void openAddPlan(View btn){
        Log.i("open","openAddPlan");
        openAddPlan();
    }
    private void openAddPlan(){
        Intent addPlan = new Intent(this,addPlan.class);
        startActivity(addPlan);
    }


 
}
