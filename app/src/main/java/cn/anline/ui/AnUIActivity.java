package cn.anline.ui;
/*
安浪Android UI界面库 索引页
Author:jiankian
QQ:746586176
Mail:i@asmm.cn
Website:www.anline.cn
Blog:www.jiankian.com
*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.anline.ui.girdview.AnGirdActivity;
import cn.anline.ui.listview.AnListActivity;
import cn.anline.ui.tabview.TabActivity;

public class AnUIActivity extends AppCompatActivity {
//    初始化元素类
        Button edit_send,btn_list_1,btn_grid_1,btn_tab_1;
        EditText edit_message;

//    初始化id
    public void initFindID(){
      edit_message = (EditText) findViewById(R.id.edit_message);
      edit_send    = (Button) findViewById(R.id.btn_send1);
      btn_list_1   = (Button)findViewById(R.id.btn_list_1);
      btn_grid_1   = (Button)findViewById(R.id.btn_grid_1);
      btn_tab_1    =  (Button)findViewById(R.id.btn_tab_1);
    }

//    监听单击事件类
public class OnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_list_1:
                Intent list1 = new Intent(AnUIActivity.this, AnListActivity.class);
                startActivity(list1);
                break;
            case R.id.btn_grid_1:
                Intent grid1 = new Intent(AnUIActivity.this, AnGirdActivity.class);
                startActivity(grid1);
                break;
            case R.id.btn_tab_1:
                Intent tab1 =new Intent(AnUIActivity.this, TabActivity.class);
                startActivity(tab1);
                break;
            default:
                Toast.makeText(getApplicationContext(),"点击无效",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

//    点击监听
    public void setListen(){
        btn_list_1.setOnClickListener(new OnClickListener());
        btn_grid_1.setOnClickListener(new OnClickListener());
        btn_tab_1.setOnClickListener(new OnClickListener());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_ui);
        initFindID();
        setListen();
    }
}
