package cn.edu.swufe.tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

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
            tieziEvaluate.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            tieziEvaluate.setGravity(Gravity.TOP);
            tieziEvaluate.setSingleLine(false);
            tieziEvaluate.setHorizontallyScrolling(false);

            Spinner spinner=(Spinner)childAt.findViewById(R.id.spinnerTiezi);
            spinner.getSelectedItem();
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
                    String result=parent.getItemAtPosition(pos).toString();
                    Log.i("Spinner实例", result);
                }
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            });
            Log.e(TAG, "景区：" +spinner + "-----评价星数："
                    + (int) tieziEvaluateStart.getRating() + "-----服务评价：" + tieziEvaluate.getText().toString());

        }
    }


}





