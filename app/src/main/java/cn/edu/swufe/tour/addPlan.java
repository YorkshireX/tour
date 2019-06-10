package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class addPlan extends AppCompatActivity {

    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

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
        startActivity(plan);}
}
