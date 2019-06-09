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
    private ImageButton btn_interest;
    private ImageButton btn_myField;
    private ImageButton btn_store;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        btn_explore=(ImageButton)findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent explore=new Intent(firstPage.this,explorePage.class);
                startActivity(explore);
            }
        });
        btn_interest=(ImageButton)findViewById(R.id.btn_interest);
        btn_interest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent interest=new Intent(firstPage.this,interest.class);
                startActivity(interest);
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
        btn_store=(ImageButton)findViewById(R.id.btn_store);
        btn_store.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent store=new Intent(firstPage.this,store.class);
                startActivity(store);
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

    public void openIn(View btn){
        Log.i("open","openIn");
        openInterest();
    }
    private void openInterest(){
        Intent interest = new Intent(this,interest.class);
        startActivity(interest);
    }

    public void openMyFiled(View btn){
        Log.i("open","openMyField");
        openMyFiled();
    }
    private void openMyFiled(){
        Intent myFiled = new Intent(this,myField.class);
        startActivity(myFiled);
    }

    public void openStore(View btn){
        Log.i("open","openStore");
        openStore();
    }
    private void openStore(){
        Intent store = new Intent(this,store.class);
        startActivity(store);
    }


}
