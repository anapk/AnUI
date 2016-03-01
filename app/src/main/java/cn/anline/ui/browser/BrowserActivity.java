package cn.anline.ui.browser;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;
import com.umeng.update.UpdateStatus;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.anline.ui.R;

public class BrowserActivity extends Activity {

    private WebView myweb;
    private EditText et_url;
    private ImageView btn_back;
    private ImageView btn_forward;
    private ImageView url_forward;
    private ImageView refresh;
    private TextView now_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_browser);
        UmengUpdateAgent.update(this);
        UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
            @Override
            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                switch (updateStatus) {
                    case UpdateStatus.Yes:
                        UmengUpdateAgent.showUpdateDialog(getApplicationContext(), updateInfo);
                        break;
                }
            }
        });
        initView();
        myweb.loadUrl("http://www.anline.cn");
        url_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String url = et_url.getText().toString().trim();
                if (url==null||url.length()==0) {
                    url="http://www.anline.cn";
                }
                if ((!url.contains("http://"))&&(!url.contains("https://"))) {
                    url="http://"+url;
                }
                myweb.loadUrl(url);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                myweb.reload();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (myweb.canGoBack()) {
                    myweb.goBack();
                }else{
                    Toast.makeText(getApplicationContext(), "no back", 0).show();
                }
            }
        });
        btn_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (myweb.canGoForward()) {
                    myweb.goForward();;
                }else{
                    Toast.makeText(getApplicationContext(), "no forward", 0).show();
                }
            }
        });
        now_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String trim = now_url.getText().toString().trim();
                et_url.setText(trim);
                now_url.setVisibility(View.GONE);
                et_url.setVisibility(View.VISIBLE);
            }
        });
        myweb.getSettings().setJavaScriptEnabled(true);
        myweb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                now_url.setText(url);
                et_url.setVisibility(View.GONE);
                now_url.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }
        });
    }

    private void initView() {
        myweb = (WebView) findViewById(R.id.myweb);
        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_forward = (ImageView) findViewById(R.id.btn_forward);
        url_forward = (ImageView) findViewById(R.id.url_forward);
        refresh = (ImageView) findViewById(R.id.refresh);
        et_url = (EditText) findViewById(R.id.et_url);
        now_url = (TextView) findViewById(R.id.now_url);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
