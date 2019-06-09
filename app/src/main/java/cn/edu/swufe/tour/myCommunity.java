package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class myCommunity extends AppCompatActivity  {

    ImageButton ibtn_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_community);

        ibtn_place = (ImageButton) findViewById(R.id.place);
        ibtn_place.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent place=new Intent(myCommunity.this,place.class);
                startActivity(place);
            }
        });
    }

    public void openPl(View btn){
        Log.i("open","openPl");
        openPlace();
    }
    private void openPlace(){
        Intent place = new Intent(this,place.class);
        startActivity(place);
    }

}
