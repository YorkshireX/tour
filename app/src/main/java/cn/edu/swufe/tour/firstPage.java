package cn.edu.swufe.tour;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class firstPage extends AppCompatActivity {

    private ImageButton btn_explore;
    private List<PlaceInfo> placeList=new ArrayList<>();

   // private String[] data={"洛带古镇","安仁古镇","黄龙溪古镇","街子古镇","怀远古镇","悦来古镇"};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        initPlaceInfo();
        placeAdapter adapter=new placeAdapter(firstPage.this,R.layout.activity_place_item,placeList);

        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,data);


        btn_explore = findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explore = new Intent(firstPage.this, explorePage.class);
                startActivity(explore);
            }
        });

       ListView  list_place = (ListView) findViewById(R.id.list_place);
       list_place.setAdapter(adapter);



    }

    private void initPlaceInfo(){
        for(int i=0;i<2;i++){
            PlaceInfo luodai = new PlaceInfo("洛带古镇","成都市龙泉驿区三峨街",R.drawable.luodai);
            placeList.add(luodai);
            PlaceInfo anren = new PlaceInfo("安仁古镇","成都市大邑县安仁镇",R.drawable.anren);
            placeList.add(anren);
            PlaceInfo huanglongxi = new PlaceInfo("黄龙溪古镇","成都市双流区黄龙溪镇镇龙街",R.drawable.huanglongxi);
            placeList.add(huanglongxi);
            PlaceInfo jiezi = new PlaceInfo("街子古镇","成都市崇州市惠丰路1号",R.drawable.jiezi);
            placeList.add(jiezi);
            PlaceInfo huaiyuan = new PlaceInfo("怀远古镇","成都市崇州市双怀路",R.drawable.huaiyuan);
            placeList.add(huaiyuan);
            PlaceInfo yuelai = new PlaceInfo("悦来古镇","鹤鸣乡悦来镇",R.drawable.yuelai);
            placeList.add(yuelai);
        }
    }



    public void openEx(View btn){
        Log.i("open","openEx");
        openExplore();
    }
    private void openExplore(){
        Intent explore = new Intent(this,explorePage.class);
        startActivity(explore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_field, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.tiezi:
                Toast.makeText(this, "您点击了"+item.getTitle().toString(),
                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(firstPage.this,tiezi.class);
                startActivity(intent);
                break;
            case R.id.myFootprint:
                Toast.makeText(this, "您点击了"+item.getTitle().toString(),
                        Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

  /*  @Override
    public void run() {

        Log.i(TAG,"run: run()......");
        for(int i=1;i<3;i++){
            Log.i(TAG,"run: i+" +i);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        List<PlaceInfo> placeInfoList = new ArrayList<>();

        //用于保存获取的汇率
        //Bundle bundle = new Bundle();
        //获取网络数据
        //bundle = getFromBOC();
        //bundle中保存所获取的汇率

        //获取Msg对象，用于返回主线程
        Message msg= handler.obtainMessage(5);
        msg.obj=list_place;
        handler.sendMessage(msg);

        //获取网络数据

        Document doc = null;
        try {
            doc = Jsoup.connect("https://map.baidu.com/search/%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%20%E5%8F%A4%E9%95%87/@11582670,3571530,13z?querytype=con&wd=%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%2B%E5%8F%A4%E9%95%87&c=75&provider=pc-aladin&pn=0&device_ratio=2&da_src=shareurl").get();
            Log.i(TAG,"run: "+doc.title());
           Elements uls = doc.getElementsByClass("poilist");
           Element ul = uls.get(0);

           Elements lis = ul.getElementsByTag("li");
           for (int i=0;i<lis.size();i++){
               Element li = lis.get(i);

               Elements divs = li.getElementsByTag("div");
               Element div = divs.get(0);

               Elements div2s = div.getElementsByClass("ml_30 mr_90");
               Element div1 = div2s.get(0);
               Element div2 = div2s.get(1);
               Element div3 = div2s.get(2);

               String placeStr = div1.text();
               String labelStr = div2.text();
               String addressStr = div3.text();


           }


        } catch (IOException e) {
            e.printStackTrace();
        }


        //https://map.baidu.com/search/%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%20%E5%8F%A4%E9%95%87/@11582670,3571530,13z?querytype=con&wd=%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%2B%E5%8F%A4%E9%95%87&c=75&provider=pc-aladin&pn=0&device_ratio=2&da_src=shareurl");

    }

   /* private Bundle getFromBOC() {
        Bundle bundle = new Bundle();
        org.jsoup.nodes.Document doc=null;
        try {
            doc = Jsoup.connect("https://map.baidu.com/search/%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%20%E5%8F%A4%E9%95%87/@11582670,3571530,13z?querytype=con&wd=%E6%88%90%E9%83%BD%E6%99%AF%E5%8C%BA%2B%E5%8F%A4%E9%95%87&c=75&provider=pc-aladin&pn=0&device_ratio=2&da_src=shareurl\");\n").get();
            Log.i(TAG, "run: " + doc.title());
            Elements uls = doc.getElementsByTag("ul");

            org.jsoup.nodes.Element ul=uls.get(2);
            //获取li中的数据
            Elements lis = ul.getElementsByTag("li");
            for(int i=0;i<lis.size();i+=10){
                org.jsoup.nodes.Element li=lis.get(i);

                Elements divs = li.getElementsByTag("div");
                org.jsoup.nodes.Element div1=divs.get(0);

                Elements div2s = div1.getElementsByTag("div");
                org.jsoup.nodes.Element div20=div2s.get(0);
                org.jsoup.nodes.Element div21=div2s.get(1);
                org.jsoup.nodes.Element div22=div2s.get(2);

                String place1=div20.text();
                String place2=div21.text();
                String place3=div22.text();

            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return bundle;
    }*/


    /*private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "gb2312");
        while (true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    } */


}

