package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class planList extends AppCompatActivity {

    String TAG = "planlist";
    TextView plan_place;
    TextView plan_time;
    TextView plan_other;
    TextView plan_medi;
    TextView plan_cloth;
    TextView plan_card;
    TextView plan_sun;
    TextView plan_rain;

    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_list);

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent home=new Intent(planList.this,firstPage.class);
                startActivity(home);
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

        Log.i(TAG,"onCreate: plan_place = " + place);
        Log.i(TAG,"onCreate: plan_time = " + time);
        Log.i(TAG,"onCreate: plan_other = " + other);
        Log.i(TAG,"onCreate: plan_medi = " + medi);
        Log.i(TAG,"onCreate: plan_cloth = " + cloth);
        Log.i(TAG,"onCreate: plan_card = " + card);
        Log.i(TAG,"onCreate: plan_sun = " + sun);
        Log.i(TAG,"onCreate: plan_rain = " + rain);

        plan_place =findViewById(R.id.plan_place);
        plan_time = findViewById(R.id.plan_time);
        plan_other = findViewById(R.id.plan_other);
        plan_medi = findViewById(R.id.plan_medi);
        plan_card = findViewById(R.id.plan_card);
        plan_cloth = findViewById(R.id.plan_cloth);
        plan_sun = findViewById(R.id.plan_sun);
        plan_rain = findViewById(R.id.plan_rain);

        //显示数据到控件
        plan_place.setText(place);
        plan_time.setText(time);
        plan_other.setText(other);
        plan_medi.setText(medi);
        plan_cloth.setText(cloth);
        plan_card.setText(card);
        plan_sun.setText(sun);
        plan_rain.setText(rain);


    }
}
