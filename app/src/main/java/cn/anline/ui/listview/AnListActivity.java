package cn.anline.ui.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.anline.ui.R;

public class AnListActivity extends ListActivity {
    String[] aTitle = {
            "安浪网络",
            "安浪电商",
            "安浪投资",
            "安浪教育",
            "安浪家居",
            "安浪汽车",
            "安浪创业",
            "安浪硬件",
            "安浪农业"
    };
    int[] aPic ={
            R.drawable.m1,
            R.drawable.m2,
            R.drawable.m3,
            R.drawable.m4,
            R.drawable.m5,
            R.drawable.m6,
            R.drawable.m7,
            R.drawable.m8,
            R.drawable.m9

    };
    String[] aDesc ={
            "网站建设，网站开发，域名注册，主机开通，服务器运营维护",
            "网络营销，产品视觉设计，产品渠道，销售管理系统，在线支付",
            "网贷系统，理财系统，信用卡服务，外贸货币",
            "在线编程，视频讲课，远程教育，课程系统，在线考试",
            "智能家居，室内环保，家用电器，装修设计，地产中介服务",
            "汽车销售，汽车修理，汽车装饰，二手车交易，租车",
            "大众创新，万众创业，艰苦奋斗，融资合伙",
            "物联网硬件，串口程序，控制系统，机器人开发",
            "地区特产，绿色农产品，在线农场，生鲜果蔬和肉类"
    };
    ArrayList<Map<String,Object>> aData = new ArrayList<Map<String,Object>>();
    ListView aListView =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        aListView =getListView();
        int lengh = aTitle.length;
        for (int i=0;i<lengh;i++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("title",aTitle[i]);
            item.put("pic",aPic[i]);
            item.put("desc",aDesc[i]);
            aData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,aData,R.layout.activity_an_list,new String[]{"title","pic","desc"},new int[]{R.id.myT1,R.id.myPic,R.id.myT2});
        setListAdapter(adapter);
        aListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"标题："+aTitle[position]+"；内容："+aDesc[position],Toast.LENGTH_SHORT).show();
            }
        });
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_an_list);
    }
}
