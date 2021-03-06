package cn.anline.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.anline.ui.browser.BrowserActivity;
import cn.anline.ui.tagview.TagViewActivity;
import cn.anline.ui.viewpager.ViewPagerActivity;
import cn.anline.ui.wpui.WpUIActivity;

public class AnUI2Activity extends AppCompatActivity {
    private Button btn_back_first_ui,btn_tagview1,btn_wpuiview1,btn_browser1,btn_viewpager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_ui2);
        btn_back_first_ui = (Button)findViewById(R.id.back_first_ui);
        btn_tagview1 = (Button)findViewById(R.id.btn_tagview);
        btn_wpuiview1 = (Button)findViewById(R.id.btn_wpui);
        btn_browser1 = (Button)findViewById(R.id.btn_browser);
        btn_viewpager1 = (Button) findViewById(R.id.btn_viewpager_1);
        btn_back_first_ui.setOnClickListener(new OnclickListener());
        btn_tagview1.setOnClickListener(new OnclickListener());
        btn_wpuiview1.setOnClickListener(new OnclickListener());
        btn_browser1.setOnClickListener(new OnclickListener());
        btn_viewpager1.setOnClickListener(new OnclickListener());
    }
    public class OnclickListener implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn_tagview:
                    Intent tagViewInet =new Intent(getApplicationContext(), TagViewActivity.class);
                    startActivity(tagViewInet);
                    break;
                case R.id.btn_wpui:
                    Intent wpUIInt = new Intent(getApplicationContext(), WpUIActivity.class);
                    startActivity(wpUIInt);
                    break;
                case R.id.back_first_ui:
                    Intent firstUI = new Intent(getApplicationContext(),AnUIActivity.class);
                    startActivity(firstUI);
                case R.id.btn_browser:
                    Intent browserInt = new Intent(getApplicationContext(), BrowserActivity.class);
                    startActivity(browserInt);
                    break;
                case R.id.btn_viewpager_1:
                    Intent viewPg1Int = new Intent(getApplicationContext(), ViewPagerActivity.class);
                    startActivity(viewPg1Int);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"点击无效",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
