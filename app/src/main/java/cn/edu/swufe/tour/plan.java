package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class plan extends AppCompatActivity {

    public final String TAG = "plan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        Intent intent = getIntent();
        String place = intent.getStringExtra("plan_place");
        String time = intent.getStringExtra("plan_time");
        String no = intent.getStringExtra("plan_no");
        String medi = intent.getStringExtra("plan_medi");
        String cloth = intent.getStringExtra("plan_cloth");
        String card = intent.getStringExtra("plan_card");
        String sun = intent.getStringExtra("plan_sun");
        String rain = intent.getStringExtra("plan_rain");

        Log.i(TAG,"onCreate: place=" + place);
        Log.i(TAG,"onCreate: time=" + time);
        Log.i(TAG,"onCreate: no=" + no);
        Log.i(TAG,"onCreate: medi=" + medi);
        Log.i(TAG,"onCreate: cloth=" + cloth);
        Log.i(TAG,"onCreate: card=" + card);
        Log.i(TAG,"onCreate: sun=" + sun);
        Log.i(TAG,"onCreate: rain=" + rain);

        ListView listView = findViewById(R.id.planlist);
        String data[] = {"2019.5.1--10：00 西安 秦始皇兵马俑博物馆","2019.5.1--14：00 西安 大唐芙蓉园",
                "2019.5.2--9：30 西安 西安钟楼","2019.5.2--15：00 西安 华清宫"};

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }

}
