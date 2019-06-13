package cn.edu.swufe.tour;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class firstPage extends AppCompatActivity {

    private ImageButton btn_explore;
    private ImageButton btn_myField;
    private Button btn_sure;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        btn_sure=(Button)findViewById(R.id.btn_sure);
        btn_sure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent explore=new Intent(firstPage.this,explorePage.class);
                startActivity(explore);
            }
        });

        btn_explore=(ImageButton)findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent explore=new Intent(firstPage.this,explorePage.class);
                startActivity(explore);
            }
        });

        btn_myField=(ImageButton)findViewById(R.id.btn_myField);
        btn_myField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myField=new Intent(firstPage.this,myField.class);
                startActivity(myField);
            }
        });

    }


    public void openEx(View btn){
        Log.i("open","openEx");
        openExplore();
    }
    private void openExplore(){
        Intent explore = new Intent(this,explorePage.class);
        startActivity(explore);
    }



    public void openMyFiled(View btn){
        Log.i("open","openMyField");
        openMyFiled();
    }
    private void openMyFiled(){
        Intent myFiled = new Intent(this,myField.class);
        startActivity(myFiled);
    }



}
