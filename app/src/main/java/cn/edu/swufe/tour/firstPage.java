package cn.edu.swufe.tour;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
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
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;


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
  //  private List<PlaceInfo> placeList=new ArrayList<>();
    private ListView list_plsce = null;

    private Spinner spinner;
    private GridView gridview;
    private List<Map<String,Object>> dataList;
    private SimpleAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        final GridView gridview = (GridView) findViewById(R.id.mylist);

        Resources res =getResources();
        String[] city=res.getStringArray(R.array.city);
        //将province中内容添加到数组city中
        spinner = (Spinner) findViewById(R.id.spinnerCC);
        //获取到spacer1
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
        //创建Arrayadapter适配器
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//通过此方法为下拉列表设置点击事件
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text= spinner.getItemAtPosition(i).toString();
                if(text.equals("河南")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.henan);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_henan);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("四川")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.sichuan);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_sichuan);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("安徽")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.anhui);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_anhui);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("浙江")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.zhejiang);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_zhejiang);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("江西")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.jiangxi);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_jiangxi);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("江苏")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.jiangsu);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_jiangsu);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("山西")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.shanxi1);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_shanxi1);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("云南")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.yunnan);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_yunnan);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("贵州")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.guizhou);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_guizhou);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("福建")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.fujian);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_fujian);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("广西")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.guangxi);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_guangxi);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("广东")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.guangdong);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_guangdong);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("重庆")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.chongqing);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_chongqing);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("湖南")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.hunan);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_hunan);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("山东")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.shandong);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_shandong);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("陕西")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.shanxi3);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_shanxi3);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("上海")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.shanghai);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_shanghai);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("河北")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.hebei);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_hebei);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("北京")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.beijing);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_beijing);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("湖北")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.hubei);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_hubei);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }else if(text.equals("台湾")){
                    Resources resp =getResources();
                    String[] guzheng = resp.getStringArray(R.array.taiwan);
                    ListAdapter gadapter = new ArrayAdapter<String>(firstPage.this,android.R.layout.simple_list_item_1,guzheng);
                    gridview.setAdapter(gadapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Resources resp =getResources();
                            String[] citiao = resp.getStringArray(R.array.ct_taiwan);
                            Uri uri = Uri.parse(citiao[position]);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                }
                // Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    /*    list_plsce = (ListView)findViewById(R.id.list_place);
        final String[] name = new String[] {"洛带古镇","安仁古镇","黄龙溪古镇","街子古镇","怀远古镇","悦来古镇"};
        final String[] message = new String[]{"洛带古镇地处成都市龙泉驿区境内，是成都“东山五场”之一，被誉为“中国西部客家第一镇” [1-2]  。\n" +
                "洛带古镇是四川省打造“两湖一山”旅游区的重点景区、国家AAAA级旅游景区、全国首批重点小城镇、成都市重点保护镇、成都文化旅游发展优先镇、省级历史文化名镇、全国“亿万农民健身活动先进镇”。作为世界客属第二十届恳亲大会的核心分会场之一，洛带被世人称之为“世界的洛带、永远的客家”，“天下客家”的定位也得以确立。\n" +
                "洛带古镇位于龙泉镇北10公里，坐落在龙泉山脉中段的二峨山麓。建于三国蜀汉时期，传说因蜀汉后主刘禅的玉带落入镇旁的八角井中而得名,镇上居民中客家人有2万多人，占全镇人数的9成; 故有中国西部客家第一镇之称。",
        "安仁古镇地处成都平原西部，距成都41公里、双流国际机场38公里、大邑县城8公里，处于成温邛高速公路和川西旅游环线上。\n" +
                "安仁古镇历史悠久，早在唐武德三年（公元620年）就建安仁县（早于大邑建县50多年），隶属于剑南道邛州，据《太平寰宇记》载由“取仁者安仁之意”而得名，当时的县治就在今天的安仁镇，因古为“安仁”县治，故得名。直至元朝二十一年（公元1284年），安仁县建置撤销，其区域划归大邑县。 [1]  安仁镇是国家级重点镇、中国历史文化名镇、成都市十大魅力城镇和成都市十四个优先发展重点镇之一。\n",
        "黄龙溪古镇景区位于成都市双流区黄龙溪镇。\n" +
                "黄龙溪古名\"赤水\"，据《仁寿县志》载：\"赤水与锦江汇流，溪水褐，江水清，古人谓之黄龙溪清江，真龙内中藏\"，《隶读》著录《黄龙甘露碑》记云\"黄龙见武阳事，铸一鼎，象龙形，沉水中┉故名曰黄龙溪\"。建安24年（公元219），汉时武阳兼新津彭山之地，东县（华县）东南接壤，仁寿也象牙，黄龙所属之地，昔属武阳，今属治境，故溪以是名矣，故名曰“黄龙溪”。\n" +
                "黄龙溪古镇位于成都市双流区西南部边缘，东经103°58’，北纬30°17’，距成都市区42公里，距双流城区东升街道34公里，距天府新区华阳街道28公里，是以旅游业为龙头，农业为基础的旅游型城镇，是成都市郊区新的旅游热点，是以旅游业为主，商贸服务业为辅的旅游型山水小城镇。被誉为中国民间艺术火龙之乡、国家级小城镇建设试点镇、国家级小城镇经济综合开发示范镇、四川省首批历史文化名镇、四川省省级风景名胜区、成都市旅游重点镇、全国环境优美乡镇和成都市14个优先发展重点镇之一，有着丰富的自然景观资源和人文旅游资源。\n" +
                "黄龙溪古镇属四川省历史文化古镇及省级旅游风景区。古镇不仅风光秀丽、环境优美，还是驰名中外的天然影视摄影基地。古镇主要特色是：古街、古树、古庙、古水陆码头、古建筑和古朴的民风民俗。是国家文化部命名的中国民间艺术(火龙)之乡、国家级环境优美小城镇。素有“影视城”、“中国好莱坞”之称。 [1] \n" +
                "2017年11月，黄龙溪古镇获评“2017年度中国十大品质休闲基地”。 [2] ",
                "街子古镇，位于四川省成都市崇州，在崇州城西北25公里的凤栖山下，与青城后山连接。有以晋代古刹光严禅院为中心的32座寺庙等古迹。 街子古镇，五代时名“横渠镇”，因横于味江河畔而得名。\n" +
                        "境内有晋代古刹——光严禅院、凤栖山旅游风景区、千亩原始森林、千年银杏、千年古楠、清代古塔、清末民初古建一条街、宋代民族英雄王小波起义遗址、唐代一瓢诗人——唐求故居，有古龙潭、五柜沱、云雾洞等，全镇各种文物古迹二十余处。\n" +
                        "崇州街子镇西距成都50公里，地处邛崃山脉。它坐落于崇州城西北25公里的凤栖山下，毗邻青城后山和九龙山。街子镇东北与都江堰接壤。岷江的支流味江流经地势平缓的街子镇口，形成一泓碧潭——龙潭。古镇水系发达，地下水丰富，石板路两侧及屋前院后，常年清水不断，因而有“川西水乡”之名。“青城后花园”之称。\n" +
                        "2010年街子镇镇域幅员面积41.18平方公里，辖9个行政村，在2010年全镇的总户数为9765户，总人口为31756人。",
                "怀远古镇位于四川省崇州市，其历史可以追溯到1600多年前，古镇不大，占地仅一平方公里。古镇建筑多为清代和民国年间建造，同时保持着四门四大街的格局，现存街道30余条，其中小北街、南街、下新街、正西街、临江街等10余条保存较为完好。建筑绝大部分都按《清代工部》法则建筑的多为穿木结构。临街摆柱，前殿后院，廊楼结合和四合院引巷子住家，是怀远古镇的基本风格，而其具体街巷但有许多不同特色。",
        "大邑丘陵重镇——悦来古镇，位于成都平原西部，幅员面积26平方公里。悦来镇地处大邑县中部丘陵中心的鹤鸣乡，距县城仅8公里。属亚热带，气候温和湿润，境内平坝、丘陵、高山皆有。"};
        final int[] photo = new int[]{R.drawable.luodai,R.drawable.anren,R.drawable.huanglongxi,R.drawable.jiezi,R.drawable.huaiyuan,R.drawable.yuelai};
        final String[] address = new String[]{"成都市龙泉驿区三峨街","成都市大邑县安仁镇","成都市双流区黄龙溪镇镇龙街","成都市崇州市惠丰路1号","成都市崇州市双怀路","鹤鸣乡悦来镇"};

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.luodai);
        map1.put("address",address[0]);
        map1.put("name", name[0]);
        data.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.anren);
        map2.put("address",address[1]);
        map2.put("name", name[1]);
        data.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.huanglongxi);
        map3.put("name", name[2]);
        map3.put("address",address[2]);
        data.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("photo", R.drawable.jiezi);
        map4.put("address",address[3]);
        map4.put("name", name[3]);
        data.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("photo", R.drawable.huaiyuan);
        map5.put("address",address[4]);
        map5.put("name", name[4]);
        data.add(map5);
        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.yuelai);
        map6.put("name", name[5]);
        map6.put("address",address[5]);
        data.add(map6);

        list_plsce.setAdapter(new SimpleAdapter(this, data, R.layout.activity_place_item,new String[] { "name", "address","photo" }, new int[] { R.id.place_name,R.id.place_address,R.id.place_image }));
        list_plsce.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[position]);
                bundle.putString("message", message[position]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(firstPage.this, place.class);
                Log.i("message", message[position]);
                startActivity(intent);
            }
        });

        // initPlaceInfo();
       // placeAdapter adapter=new placeAdapter(firstPage.this,R.layout.activity_place_item,placeList);


        btn_explore = findViewById(R.id.btn_explore);
        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explore = new Intent(firstPage.this, explorePage.class);
                startActivity(explore);
            }
        });  */

      // ListView  list_place = (ListView) findViewById(R.id.list_place);
       //list_place.setAdapter(adapter);



    }

    /*private void initPlaceInfo(){
        for(int i=0;i<1;i++){
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
    }*/



    /*public void openEx(View btn){
        Log.i("open","openEx");
        openExplore();
    }
    private void openExplore(){
        Intent explore = new Intent(this,explorePage.class);
        startActivity(explore);
    }  */

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
                Intent planff=new Intent(firstPage.this,plan.class);
                startActivity(planff);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




}

