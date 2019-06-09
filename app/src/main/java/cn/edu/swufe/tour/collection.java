package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class collection extends AppCompatActivity {

    Button btn_huiZ;
    Button btn_myHuiZ;
    TextView txt_huiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        TextView txt_huiz=findViewById(R.id.txt_huiz);
        txt_huiz.setText("徽章数靠前用户的显示");

    }


    public void onClick(View v){
        Log.i("click","onClick");

        TextView txt_huiz=findViewById(R.id.txt_huiz);

        if(v.getId()==R.id.btn_huiZ){
            showHuiZ();
        }
        else{
            showMyHuiZ();
        }
    }

    private void showHuiZ(){
      //待完善：点击徽章大全之后显示什么
    }

    private void showMyHuiZ(){
     //待完善：点击我的徽章之后显示什么
    }
}
