package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class interest extends AppCompatActivity {

    private Button btn_myCommunity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        btn_myCommunity=(Button)findViewById(R.id.myCommunity);
        btn_myCommunity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent mycom=new Intent(interest.this,myCommunity.class);
                startActivity(mycom);
            }
        });

    }


    public void openMyCommunity(View btn){
        Log.i("open","openMyCommunity");
        openMyCommunity();
    }
    private void openMyCommunity(){
        Intent myCommunity = new Intent(this,myCommunity.class);
        startActivity(myCommunity);
    }
}
