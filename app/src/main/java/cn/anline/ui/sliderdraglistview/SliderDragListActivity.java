package cn.anline.ui.sliderdraglistview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.anline.ui.R;

public class SliderDragListActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_drag_list);
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_simple).setOnClickListener(this);
        findViewById(R.id.btn_header_footer).setOnClickListener(this);
        findViewById(R.id.btn_view_type).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(this, NormalActivity.class));
                break;
            case R.id.btn_simple:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.btn_header_footer:
                startActivity(new Intent(this, DemoActivity.class));
                break;
            case R.id.btn_view_type:
                startActivity(new Intent(this, DifferentActivity.class));
                break;
        }
    }
}
