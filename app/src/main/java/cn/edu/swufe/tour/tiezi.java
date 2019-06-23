package cn.edu.swufe.tour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class tiezi extends AppCompatActivity implements View.OnClickListener {


    private String TAG = this.getClass().getSimpleName();
    //装在所有动态添加的Item的LinearLayout容器
    private LinearLayout addTieziNameView;
   /* public tieziAdapter adapter;
    private Button tzx;
    private ListView mytz; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiezi);

        addTieziNameView = (LinearLayout) findViewById(R.id.ll_addView);
        findViewById(R.id.btn_getData).setOnClickListener(this);

        //默认添加一个Item
        addViewItem(null);

       /* ListView mytz = (ListView) findViewById(R.id.mytz);
       adapter = new tieziAdapter(this);
        mytz.setAdapter(adapter);  */

        }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_addTiezi://点击添加按钮就动态添加Item
                addViewItem(v);
                break;
            case R.id.btn_getData://打印数据
                printData();
                break;
        }

    }
    private void sortTieziViewItem() {
        //获取LinearLayout里面所有的view
        for (int i = 0; i < addTieziNameView.getChildCount(); i++) {
            final View childAt = addTieziNameView.getChildAt(i);
            final Button btn_remove = (Button) childAt.findViewById(R.id.btn_addTiezi);
            btn_remove.setText("删除");
            btn_remove.setTag("remove");//设置删除标记
            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //从LinearLayout容器中删除当前点击到的ViewItem
                    addTieziNameView.removeView(childAt);
                }
            });
            //如果是最后一个ViewItem，就设置为添加
            if (i == (addTieziNameView.getChildCount() - 1)) {
                Button btn_add = (Button) childAt.findViewById(R.id.btn_addTiezi);
                btn_add.setText("+新增");
                btn_add.setTag("add");
                btn_add.setOnClickListener(this);
            }
        }
    }

    //添加ViewItem
    private void addViewItem(View view) {
        if (addTieziNameView.getChildCount() == 0) {//如果一个都没有，就添加一个
            View tieziEvaluateView = View.inflate(this, R.layout.activity_tiezi_item, null);
            Button btn_add = (Button) tieziEvaluateView.findViewById(R.id.btn_addTiezi);
            btn_add.setText("+新增");
            btn_add.setTag("add");
            btn_add.setOnClickListener(this);
            addTieziNameView.addView(tieziEvaluateView);
            //sortTieziViewItem();
        } else if (((String) view.getTag()).equals("add")) {//如果有一个以上的Item,点击为添加的Item则添加
            View tieziEvaluateView = View.inflate(this, R.layout.activity_tiezi_item, null);
            addTieziNameView.addView(tieziEvaluateView);
            sortTieziViewItem();
        }
        //else {
        //  sortTieziViewItem();
        //}
    }
    //获取所有动态添加的Item，找到控件的id，获取数据
    private void printData() {
        for (int i = 0; i < addTieziNameView.getChildCount(); i++) {
            View childAt = addTieziNameView.getChildAt(i);
            RatingBar tieziEvaluateStart = (RatingBar) childAt.findViewById(R.id.rb_tiezi_evaluate);
            EditText tieziEvaluate = (EditText) childAt.findViewById(R.id.ed_tieziEvaluate);
            EditText tieziPlace = (EditText) childAt.findViewById(R.id.ed_tieziPlace);

            tieziEvaluate.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tieziEvaluate.setGravity(Gravity.TOP);
            tieziEvaluate.setSingleLine(false);
            tieziEvaluate.setHorizontallyScrolling(false);

            tieziPlace.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tieziPlace.setGravity(Gravity.TOP);
            tieziPlace.setSingleLine(false);
            tieziPlace.setHorizontallyScrolling(false);

            String text1 = tieziPlace.getText().toString();
            String text2 = tieziEvaluate.getText().toString();
            String text3 = tieziEvaluateStart.toString();
            SharedPreferences.Editor editor = getSharedPreferences("data",
                    MODE_PRIVATE).edit();
            editor.putString("TZplace", text1);
            editor.putString("TZpingjia", text2);
            editor.putString("TZstar", text3);
            editor.commit();


                    SharedPreferences pref = getSharedPreferences("data",
                    MODE_PRIVATE);
            String place = pref.getString("TZplace", "");
            String pingjia = pref.getString("TZpingjia", "");
            String star = pref.getString("TZstar", "");
            Log.d("tiezi", "place is " + place);
            Log.d("tiezi", "pingjia is " + pingjia);
            Log.d("tiezi", "star is " + star);



            Spinner spinnerTiezi = (Spinner)childAt.findViewById(R.id.spinnerTiezi);

            Resources resp =getResources();
             String[] STiezi = resp.getStringArray(R.array.city);
           /*  String[][] STZGZ = {resp.getStringArray(R.array.henan),resp.getStringArray(R.array.sichuan),resp.getStringArray(R.array.anhui),resp.getStringArray(R.array.zhejiang),
                    resp.getStringArray(R.array.jiangxi),resp.getStringArray(R.array.jiangsu),resp.getStringArray(R.array.shanxi1),resp.getStringArray(R.array.yunnan),
                    resp.getStringArray(R.array.guizhou),resp.getStringArray(R.array.fujian),resp.getStringArray(R.array.guangxi),resp.getStringArray(R.array.chongqing),
                    resp.getStringArray(R.array.hunan),resp.getStringArray(R.array.shandong),resp.getStringArray(R.array.shanxi3),resp.getStringArray(R.array.shanghai),
                    resp.getStringArray(R.array.hebei),resp.getStringArray(R.array.beijing),resp.getStringArray(R.array.hubei)}; */

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, STiezi);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);








           /* spinnerTiezi.getSelectedItem();
            spinnerTiezi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
                    String spinnerPro=(String)spinnerTiezi.getItemAtPosition(pos);
                    Log.i("Spinner实例", spinnerPro);
                }
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });


            spinnerTZGZ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String guzValue = (String) spinnerTZGZ.getItemAtPosition(position);
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        spinnerTZGZ.setSelection(0);
                    }
            });  */



            Log.e(TAG, "景区：" +tieziPlace + "-----评价星数："
                    + (int) tieziEvaluateStart.getRating() + "-----服务评价：" + tieziEvaluate.getText().toString());

        }
    }



}





