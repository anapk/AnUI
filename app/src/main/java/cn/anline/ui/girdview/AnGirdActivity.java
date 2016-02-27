package cn.anline.ui.girdview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.anline.ui.R;

public class AnGirdActivity extends Activity {
    String[] aMenu = {
                "语文",
                "数学",
                "英语",
                "地理",
                "物理",
                "政治",
                "化学",
                "历史",
                "生物"
    };
    int[] aIcon = {
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
    ArrayList<Map<String,Object>> aGdata = new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_gird);
        GridView anGrid = (GridView)findViewById(R.id.gview);
        int lengh2 = aMenu.length;
        for (int j =0;j<lengh2;j++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("menu",aMenu[j]);
            item.put("icon",aIcon[j]);
            aGdata.add(item);
        }
        SimpleAdapter adapter2 = new SimpleAdapter(this,aGdata,R.layout.gird_item,new String[]{"menu","icon"},new int[]{R.id.text_grid,R.id.image_grid});
        anGrid.setAdapter(adapter2);
    }
}
