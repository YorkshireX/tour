package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class explorePage extends AppCompatActivity {

    private Button card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_page);


        ListView listView = findViewById(R.id.list);
        String data[] = {"2019.5.1--10：00 西安 秦始皇兵马俑博物馆","2019.5.1--14：00 西安 大唐芙蓉园",
                "2019.5.2--9：30 西安 西安钟楼","2019.5.2--15：00 西安 华清宫"};

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }



}
