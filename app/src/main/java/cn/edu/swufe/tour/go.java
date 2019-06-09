package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class go extends AppCompatActivity {

    EditText search;
    Button btn_sousuo;
    TextView ssResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        ssResult = (TextView)findViewById(R.id.ssResult);
        search =(EditText) findViewById(R.id.search);
        TextView ssResult = findViewById(R.id.ssResult);

    }


    public void onClick(View v){
        Log.i("click","onClick");

        ssResult.setText("结果为：");
        String str = search.getText().toString();

    }
    public void btn_sousuo(View btn){
        showResult();
    }
    private void showResult(){

    }

}
