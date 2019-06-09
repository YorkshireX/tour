package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class place extends AppCompatActivity {

    ImageButton btn_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        btn_write=(ImageButton)findViewById(R.id.write);
        btn_write.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent write=new Intent(place.this,write.class);
                startActivity(write);
            }
        });
    }

    public void openWr(View btn){
        Log.i("open","openWi");
        openWrite();
    }
    private void openWrite(){
        Intent write = new Intent(this,write.class);
        startActivity(write);
    }
}
