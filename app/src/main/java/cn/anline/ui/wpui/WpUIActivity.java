package cn.anline.ui.wpui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import cn.anline.ui.R;

public class WpUIActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wp_ui);
        ImageView btn_wp1 = (ImageView) findViewById(R.id.btn_wp_1);
        ImageView btn_wp2 = (ImageView) findViewById(R.id.btn_wp_2);
        ImageView btn_wp3 = (ImageView) findViewById(R.id.btn_wp_3);
        ImageView btn_wp4 = (ImageView) findViewById(R.id.btn_wp_4);
        LinearLayout btn_wp_001= (LinearLayout) findViewById(R.id.btn_wp_001);
        LinearLayout btn_wp_002= (LinearLayout) findViewById(R.id.btn_wp_002);
        LinearLayout btn_wp_003= (LinearLayout) findViewById(R.id.btn_wp_003);
        LinearLayout btn_wp_004= (LinearLayout) findViewById(R.id.btn_wp_004);
        LinearLayout btn_wp_005= (LinearLayout) findViewById(R.id.btn_wp_005);
        LinearLayout btn_wp_006= (LinearLayout) findViewById(R.id.btn_wp_006);
        LinearLayout btn_wp_007= (LinearLayout) findViewById(R.id.btn_wp_007);
        LinearLayout btn_wp_008= (LinearLayout) findViewById(R.id.btn_wp_008);
        btn_wp1.setOnClickListener(this);
        btn_wp2.setOnClickListener(this);
        btn_wp3.setOnClickListener(this);
        btn_wp4.setOnClickListener(this);
        btn_wp_001.setOnClickListener(this);
        btn_wp_002.setOnClickListener(this);
        btn_wp_003.setOnClickListener(this);
        btn_wp_004.setOnClickListener(this);
        btn_wp_005.setOnClickListener(this);
        btn_wp_006.setOnClickListener(this);
        btn_wp_007.setOnClickListener(this);
        btn_wp_008.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_wp_1:
                Toast.makeText(getApplicationContext(),"点击了：下载"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_2:
                Toast.makeText(getApplicationContext(),"点击了：回收站"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_3:
                Toast.makeText(getApplicationContext(),"点击了：设置"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_4:
                Toast.makeText(getApplicationContext(),"点击了：添加"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_001:
                Toast.makeText(getApplicationContext(),"布局一",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_002:
                Toast.makeText(getApplicationContext(),"布局二",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_003:
                Toast.makeText(getApplicationContext(),"布局三",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_004:
                Toast.makeText(getApplicationContext(),"布局四",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_005:
                Toast.makeText(getApplicationContext(),"布局五",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_006:
                Toast.makeText(getApplicationContext(),"布局六",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_007:
                Toast.makeText(getApplicationContext(),"布局七",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wp_008:
                Toast.makeText(getApplicationContext(),"布局八",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),"点击无效",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
