package cn.edu.swufe.tour;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class addPlan extends AppCompatActivity {

    private EditText et_plan_place;
    private EditText et_plan_time;
    private EditText et_plan_no;
    private EditText et_plan_medi;
    private EditText et_plan_cloth;
    private EditText et_plan_card;
    private EditText et_plan_sun;
    private EditText et_plan_rain;
    private Button btn_add;

    public final String TAG = "addPlan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        et_plan_place = findViewById(R.id.et_plan_place);
        et_plan_time= findViewById(R.id.et_plan_time);
        et_plan_no = findViewById(R.id.et_plan_no);
        et_plan_medi = findViewById(R.id.et_plan_medi);
        et_plan_cloth = findViewById(R.id.et_plan_cloth);
        et_plan_card = findViewById(R.id.et_plan_card);
        et_plan_sun = findViewById(R.id.et_plan_sun);
        et_plan_rain = findViewById(R.id.et_plan_rain);

        btn_add=(Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent plan=new Intent(addPlan.this,plan.class);
                startActivity(plan);
            }
        });
    }

    public void openPlan(View btn){
        Log.i("open","openPlan");
        openPlan();
    }
    private void openPlan(){
        Intent plan = new Intent(this,plan.class);
        plan.putExtra("plan_place", String.valueOf(et_plan_place));
        plan.putExtra("plan_time", String.valueOf(et_plan_time));
        plan.putExtra("plan_no", String.valueOf(et_plan_no));
        plan.putExtra("plan_medi", String.valueOf(et_plan_medi));
        plan.putExtra("plan_cloth", String.valueOf(et_plan_cloth));
        plan.putExtra("plan_card", String.valueOf(et_plan_card));
        plan.putExtra("plan_sun", String.valueOf(et_plan_sun));
        plan.putExtra("plan_rain", String.valueOf(et_plan_rain));

        Log.i(TAG,"openPlan: plan_place = " + et_plan_place);
        Log.i(TAG,"openPlan: plan_time = " + et_plan_time);
        Log.i(TAG,"openPlan: plan_no = " + et_plan_no);
        Log.i(TAG,"openPlan: plan_medi = " + et_plan_medi);
        Log.i(TAG,"openPlan: plan_cloth = " + et_plan_cloth);
        Log.i(TAG,"openPlan: plan_card = " + et_plan_card);
        Log.i(TAG,"openPlan: plan_sun = " + et_plan_sun);
        Log.i(TAG,"openPlan: plan_rain = " + et_plan_rain);


        startActivityForResult(plan,1);
    }


}
