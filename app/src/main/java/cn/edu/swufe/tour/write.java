package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class write extends AppCompatActivity {

    private EditText xie;
    private Button btn_fabu;

    public final String TAG = "write";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        xie = findViewById(R.id.xie);

        btn_fabu = findViewById(R.id.btn_fabu);
        btn_fabu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tiezi =new Intent(write.this,tiezi.class);

                //显示数据到控件
                String xxie = xie.getText().toString();

                tiezi.putExtra("xxie",xxie);

                Log.i(TAG,"openWrite: xxie = " + xxie);

                startActivity(tiezi);
            }

        });


    }
}
