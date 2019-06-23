package cn.edu.swufe.tour;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class place extends AppCompatActivity{
    private ListView list_plsce = null;
    private List<Map<String,Object>> dataList;
    private SimpleAdapter adapter;

    Handler handler;
    private List<HashMap<String,String>> listItems;  //存放文字、图片信息
    private SimpleAdapter listItemAdapter;  //适配器


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);


       /* list_plsce = (ListView)findViewById(R.id.rank10);
        final String[] name = new String[] {"黄姚古镇","丹巴藏寨","喀纳斯湖畔古村落","婺源古镇","乌镇","周庄","同里镇","西塘古镇","赤坎古镇","富田古镇"};
        final String[] message = new String[]{"黄姚位于广西昭平县，距桂林200公里，是一个有九百多年历史文化的明清古镇，地处漓江下游，素有“诗境家园”之称。古镇方圆1平方公里，为典型的喀斯特地貌。\n" +
                "黄姚是个充满诗意的地方，每一外景点都不需刻意寻找，沿着石板路慢慢走，也许在无意间你就可能会发现一些令你惊喜的东西。\n" +
                "全镇居民有600多户，八条街道，房屋多数保持明清风格，街道均用青石板砌成。古镇保存有寺观庙祠20多座，亭台楼阁10多处，多为明清建筑，著名的有文明阁、宝珠观、兴宇庙、狮子庙、古戏台、吴家祠、郭家祠、佐龙寺、见龙寺、带龙桥、护龙桥、天然亭等。人文景观还有韩愈、刘宗标墨迹、钱兴烈士塑像、何香凝、高士其、千家驹等文化名人寓所，以及许多诗联碑刻。一般来说，比较常规的景点包括中共广西省工委旧址纪念馆、古戏台、皇帝诏书、宝珠观、鲤鱼街、八仙睡榕、佐龙桥、千年古榕、岭南第一石板街等。","" +
                "丹巴县位于四川西部的甘孜藏族自治州东部旁，与道孚、康定县和阿坝州小金、金川县接壤，全县总全面积5649平方公里，辖一镇十四乡，居住着以藏族为主的15个民族共5.7万余人。丹巴县是巴颜喀拉山脉、邛崃山脉等汇聚的地方，又是革什扎河、牦牛河、大小金川河的发源或流径处素有“岩巅上的城”和“大渡河畔第一城”之称。这里山峦连绵起伏，湖泊星落棋布，森林无边无际，当地藏民族把这种特征括为“山顶积雪皑皑，山腰树林葱葱，山脚海子粼粼”。是一个深藏于横断山脉中鲜为人知的世外桃源，壮丽迷人的风光、无限神秘的美人山谷、恬静如诗的乡土民居、独具一格的古石碉楼、多姿多彩的风情，惊现出丹巴的神奇和美丽。",
                "图瓦村位于喀纳斯湖南岸3公里处的喀纳斯河谷地带，周围山青水秀，环境优美，是布尔津县前往喀纳斯湖旅游的必经之路。图瓦村居住有100多户，1400多人。图瓦人多居住在用松木搭建的塔形木屋中，这种建筑称作“木楞屋”，四壁均为原木垒砌，有天棚有地板，屋顶尖斜，以适应山区多雨雪的环境。\n" +
                        "图瓦人的生产生活方式主要是以牧业为主，以狩猎、捕鱼和采集为辅。春暖花开时节，他们赶着牛羊去深山里的夏牧场；深秋时分，又赶着牲畜下山，住进木屋度过漫长的冬季。图瓦人主要居住在禾木-喀纳斯蒙古民族乡的禾木村、喀纳斯村，以及喀纳斯湖西面18公里外的白哈巴村，人口约有2000人左右。",
        "江西省上饶地区辖县，江西最大产茶基地。位于赣东北乐安江上游，北邻安徽，东毗浙江。面积2947平方公里，人口32.04万。县府驻紫阳镇。唐置县，北宋徽宗宣和三年(1121)隶属徽州。1934年由安徽划入江西。县境以山地、丘陵为主，约占总面积的80%，余为低丘、岗地。最高峰擂鼓尖在与安徽省交界处，海拔1630米。属中亚热带湿润季风气候，年降水量1500~2000毫米，有利林木生长。全县林地占土地面积的49%，活立木蓄积量达820余万立方米。盛产松、杉、毛竹和茶叶、油茶、香菇等。茶叶产量常占全省的1/3，绿茶素称“婺绿”，与武宁县的“宁红”齐名。其他土特产有龙尾砚、婺墨等。矿产资源有煤、铁、钨、金、铜和砚石等。",
        "乌镇是江南水乡六大古镇之一，古风犹存的东、西、南、北四条老街呈“十”字交叉，构成双棋盘式河街平行、水陆相邻的古镇格局。这里的民居宅屋傍河而筑，街道两旁保存有大量的明清建筑，辅以河上石桥，体现了小桥、流水、古宅的江南古镇风韵。镇东的立志书院是茅盾少年时的读书处，现辟为茅盾纪念馆，为国家级重点文物保护单位。镇上的西栅老街是中国保存最完好的明清建筑群之一。此外，还有修真观戏台、双桥风情、梁苑胜迹、唐代银杏等众多景点，当地有：贺岁拜年、元宵走桥、清明踏青、立夏称人、端午吃粽、分龙彩雨、天贶晒虫、中元河灯、中秋赏月、重九登高、冬至祀祖、腊月小更等习俗。",
        "史载于1086年的周庄，位于上海、苏州、杭州之间。镇为泽国，四面环水，咫尺往来，皆须舟楫。全镇依河成街，桥街相连，深宅大院，重脊高檐，河埠廊坊，过街骑楼，穿竹石栏，临河水阁，一派古朴幽静，是江南典型的小桥流水人家。\n" +
                "唐风孑遗，宋水依依，烟雨江南，碧玉周庄。千年历史沧桑和浓郁吴地文化孕育的周庄，以其灵秀的水乡风貌，独特的人文景观，质朴的民俗风情，成为东方文化的瑰宝。作为中国优秀传统文化杰出代表的周庄，成为吴地文化的摇篮，江南水乡的典范。被联合国教科文组织列入世界文化遗产预备清单，荣获迪拜国际改善居住环境最佳范例奖，联合国亚太地区世界文化遗产保护杰出成就奖、美国政府奖、世界最具魅力水乡和中国首批十大历史文化名镇、中华环境奖、国家卫生镇、全国环境优美乡镇等殊荣。",
        "同里镇，位于太湖之畔古运河之东。她建于宋代，至今已有1000多年历史，是名副其实的水乡古镇。同里镇距苏州市18公里，距上海80公里，是为江南六大著名水乡之一，面积33公顷，为五个湖泊环抱，由网状河流将镇区分割成七个岛。古镇风景优美，镇外四面环水。她是江苏省最早(1982年)，也是唯一将全镇作为文物保护单位的古镇。1995年更被列为江苏省首批历史文化名镇。1998年水乡古镇和退思园被列入世界文化遗产预备清单。"
        ,"古镇西塘位于浙江省嘉兴市嘉善县，距嘉善县城11公里，西塘是一座已有千年历史文化的古镇。早在春秋战国时期就是吴越两国的相交之地，故有“吴根越角”和“越角人家”之称。到元代初步形成市集。西塘与其它水乡古镇最大的不同在于古镇中临河的街道都有廊棚，总长近千米，就像颐和园的长廊一样。在西塘旅游，雨天不淋雨，晴天太阳也晒不到。",
        "赤坎古镇位于江门市辖下的开平市中部，距开平中心城区12公里，有350多年历史，是一座具有浓郁岭南特色和深厚文化底蕴的古镇。潭江横贯全镇，总人口4.8万人，海外华侨、港、澳、台同胞共7.2万人，是著名的侨乡。赤坎境内保留有大量的华侨建筑，中西合璧。赤坎沿潭江而建，南岸是乡村，北岸是市镇，清一色的骑楼，庞大的洋楼群。赤坎的玩法便是闲游浪荡，在老街上体验似乎尚停留于上个世纪80年代的生活。古镇上也有碉楼，而远近闻名的关族和司徒氏图书馆、堤西路的骑楼建筑群更是侨乡一绝，已被省政府定为文物保护单位。",
        "富田镇是国家级旅游景区，一座拥有1800多年历史的古镇，通行赣语，这里是民族英雄文天祥、著名史学家罗泌和原上海市委第二书记胡立教的故乡，是庐陵文化重要发祥地，是爸爸去那儿第三季拍摄地 ，红色、古色、绿色旅游资源交相辉映。自古以来，庐陵就流传着这样一句顺口溜：“匡家匡娘娘，文家出了个文丞相，王家有座大祠堂。”这句话涵盖了富田古镇的三个特色景点——匡家娘娘祠—崇孝堂、文天祥故里、王家大祠堂—诚敬堂。距吉安市区46公里，镇域面积216平方公里，人口约3万人，境内通行赣语方言，基本上为江右民系。2010年被国家住房与城乡建设部和国家文物局授予了中国历史文化名镇称号，2012年被国家环保部评为国家生态镇。2015年1月20日公布了全国第二批建设宜居小镇，是中国传统村落最多的古镇！"};
        final int[] photo = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.a);
        map1.put("message",message[0]);
        map1.put("name", name[0]);
        data.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.b);
        map2.put("address",message[1]);
        map2.put("name", name[1]);
        data.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.c);
        map3.put("name", name[2]);
        map3.put("address",message[2]);
        data.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("photo", R.drawable.d);
        map4.put("address",message[3]);
        map4.put("name", name[3]);
        data.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("photo", R.drawable.e);
        map5.put("address",message[4]);
        map5.put("name", name[4]);
        data.add(map5);
        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.f);
        map6.put("name", name[5]);
        map6.put("address",message[5]);
        data.add(map6);
        Map<String, Object> map7 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.g);
        map6.put("name", name[6]);
        map6.put("address",message[6]);
        data.add(map7);
        Map<String, Object> map8 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.h);
        map6.put("name", name[7]);
        map6.put("address",message[7]);
        data.add(map8);
        Map<String, Object> map9 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.i);
        map6.put("name", name[8]);
        map6.put("address",message[8]);
        data.add(map9);
        Map<String, Object> map10 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.j);
        map6.put("name", name[9]);
        map6.put("address",message[9]);
        data.add(map10);


       /* Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");
        ImageView Iv_place=(ImageView) findViewById(R.id.Iv_place);
        Iv_place.setImageResource(id);
        TextView tv=(TextView) findViewById(R.id.place_message);
        tv.setText(message);  */
    }

    private void setListAdapter(SimpleAdapter listItemAdapter) {
    }


}
