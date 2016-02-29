package cn.anline.ui.qrcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.anline.ui.R;

public class ResultTextShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_text_show);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_RsTextShow);
//        toolbar.setTitle("二维码解析结果");
//        toolbar.setSubtitle("解析结果");

        Bundle extras = getIntent().getExtras();
        String rsTextValue = extras.getString("rsText");
        TextView textView_rsText =(TextView) findViewById(R.id.textView_rsText);
        textView_rsText.setText(rsTextValue);
    }
}
