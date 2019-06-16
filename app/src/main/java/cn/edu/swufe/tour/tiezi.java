package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class tiezi extends AppCompatActivity {

    String TAG = "tzlist";
    private List<TieziInfo> tzList=new ArrayList<>();
    private ImageButton tz_home;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiezi);

        tz_home = findViewById(R.id.tz_home);
        tz_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(tiezi.this, firstPage.class);
                startActivity(home);
            }
        });

        Intent intent = getIntent();
        String xxxie = intent.getStringExtra("xxie");
        Log.i(TAG, "onCreate: xie = " + xxxie);

        initTieziInfo();
        tieziAdapter adapter = new tieziAdapter(tiezi.this,R.layout.activity_tiezi_item, tzList);

        ListView mytz = findViewById(R.id.mytz);
        mytz.setAdapter(adapter);
        tv=findViewById(R.id.tv_tz);
        tv.setText(xxxie);
    }

    private void initTieziInfo() {
        for (int i = 0; i < 1; i++) {
            TieziInfo tttz = new TieziInfo(tv.toString());
            tzList.add(tttz);
        }
    }
}
