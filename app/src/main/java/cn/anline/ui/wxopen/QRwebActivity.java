package cn.anline.ui.wxopen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
import com.tencent.mm.sdk.openapi.ConstantsAPI;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXAppExtendObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXWebpageObject;

import cn.anline.ui.R;
import cn.anline.ui.qrcode.ScannerActivity;

public class QRwebActivity extends Activity implements IWXAPIEventHandler {
    private ImageView iv_home, iv_menu;
    private RelativeLayout level1, level2, level3;
    private Button button, button1, button2, button3, button4, button5;
    private WebView webView1;
    private boolean isShowLevel2 = true;// 是否显示2级菜单
    private boolean isShowLevel3 = true;// 是否显示3级菜单
    private boolean isShowMenu = true;// 是否显示整个菜单，包括1级，2级，3级的菜单

    private IWXAPI api;
//    String rsUrlValue = new String("");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);
        api.registerApp(Constants.APP_ID);
        initView();
        setListener();
//        if(rsUrlValue!=null){
//            webView1.loadUrl(rsUrlValue);
//        }else{
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            String resUrlValue = extras.getString("QRUrl");
            webView1.loadUrl(resUrlValue);
        }else{
            webView1.loadUrl("http://app.anline.cn");
        }
//        }
        webView1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return super.shouldOverrideUrlLoading(view, "http://app.anline.cn");
                } else if (url.startsWith("sms:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return super.shouldOverrideUrlLoading(view, "http://app.anline.cn");
                } else {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                view.loadUrl("file:///android_asset/error.html");
            }
        });
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                goToGetMsg();
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                goToShowMsg((ShowMessageFromWX.Req) req);
                break;
            default:
                break;
        }
    }

    // ������Ӧ�÷��͵�΢�ŵ�����������Ӧ�������ص����÷���
    @Override
    public void onResp(BaseResp resp) {
        int result = 0;

        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                result = R.string.errcode_success;
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = R.string.errcode_cancel;
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result = R.string.errcode_deny;
                break;
            default:
                result = R.string.errcode_unknown;
                break;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }

    private void goToGetMsg() {
        Intent intent = new Intent(this, GetFromWXActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
        finish();
    }

    private void goToShowMsg(ShowMessageFromWX.Req showReq) {
        WXMediaMessage wxMsg = showReq.message;
        WXAppExtendObject obj = (WXAppExtendObject) wxMsg.mediaObject;

        StringBuffer msg = new StringBuffer(); // ��֯һ������ʾ����Ϣ����
        msg.append("description: ");
        msg.append(wxMsg.description);
        msg.append("\n");
        msg.append("extInfo: ");
        msg.append(obj.extInfo);
        msg.append("\n");
        msg.append("filePath: ");
        msg.append(obj.filePath);

        Intent intent = new Intent(this, ShowFromWXActivity.class);
        intent.putExtra(Constants.ShowMsgActivity.STitle, wxMsg.title);
        intent.putExtra(Constants.ShowMsgActivity.SMessage, msg.toString());
        intent.putExtra(Constants.ShowMsgActivity.BAThumbData, wxMsg.thumbData);
        startActivity(intent);
        finish();
    }

    /**
     * 初始化空间
     */
    private void initView() {
        setContentView(R.layout.activity_web);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        button = (Button) findViewById(R.id.btn_webview_back);
        button1 = (Button) findViewById(R.id.btn_wx_session);
        button4 = (Button) findViewById(R.id.btn_wx_timeline);
        button2 = (Button) findViewById(R.id.btn_qr_scan);
        button3 = (Button) findViewById(R.id.btn_voice);
        button5 = (Button) findViewById(R.id.btn_face_scan);
        webView1 = (WebView) findViewById(R.id.webView1);
        WebSettings settings = webView1.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    /**
     * 设置监听事件
     */
    private void setListener() {
        iv_home.setOnClickListener(new OnClickListener());
        iv_menu.setOnClickListener(new OnClickListener());
        button.setOnClickListener(new OnClickListener());
        button1.setOnClickListener(new OnClickListener());
        button2.setOnClickListener(new OnClickListener());
        button3.setOnClickListener(new OnClickListener());
        button4.setOnClickListener(new OnClickListener());
        button5.setOnClickListener(new OnClickListener());
    }

    public class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            if(v.getId()==R.id.button){
//
//            }else if (v.getId()==R.id.button){
//
//            }
            switch (v.getId()) {
                case R.id.iv_home:
                    //当动画都结束的时候才可以操作
                    if (AnimUtil.animCount != 0) {
                        // 说明有动画在执行
                        return;
                    }
                    if (isShowLevel2) {
                        // 需要隐藏
                        int startOffset = 0;
                        if (isShowLevel3) {
                            AnimUtil.showOrChoseMenu(level3, startOffset, false);
                            startOffset += 200;//因为菜单3先隐藏 所以给菜单200秒的延时
                            isShowLevel3 = false;
                        }

                        AnimUtil.showOrChoseMenu(level2, startOffset, false);
                    } else {
                        // 需要显示
                        // Log.e(tag, "执行显示操作");
                        AnimUtil.showOrChoseMenu(level2, 0, true);
                    }
                    isShowLevel2 = !isShowLevel2;
                    break;
                case R.id.iv_menu:
                    //当动画都结束的时候才可以操作
                    if (AnimUtil.animCount != 0) {
                        // 说明有动画在执行
                        return;
                    }
                    if (isShowLevel3) {
                        // 隐藏3级菜单
                        AnimUtil.showOrChoseMenu(level3, 0, false);
                    } else {
                        // 显示3级菜单
                        AnimUtil.showOrChoseMenu(level3, 0, true);
                    }
                    isShowLevel3 = !isShowLevel3;
                    break;
                case R.id.btn_webview_back:
                    webView1.goBack();
                    break;
                case R.id.btn_wx_session: {
                    Log.d("按钮", "发微信信息");
                    Toast.makeText(getApplicationContext(), "发送给微信好友", Toast.LENGTH_SHORT).show();
                    WXWebpageObject webpage = new WXWebpageObject();
                    webpage.webpageUrl = webView1.getUrl();
                    WXMediaMessage msg = new WXMediaMessage(webpage);
                    msg.title = webView1.getTitle();
                    msg.description = "安浪创想网：从事互联网技术产品开发，专注于信息技术领域的高端商业资源开发，技术型、创新型、公益性网站，欢迎合作、共赢！";
                    Bitmap thumb = BitmapFactory.decodeResource(getResources(), R.drawable.send_music_thumb);
                    msg.thumbData = Util.bmpToByteArray(thumb, true);
                    SendMessageToWX.Req req = new SendMessageToWX.Req();
                    req.transaction = buildTransaction("webpage");
                    req.message = msg;
                    req.scene = SendMessageToWX.Req.WXSceneSession;
                    api.sendReq(req);
//                finish();
                }
                break;
                case R.id.btn_wx_timeline: {
                    Log.d("按钮", "发微信朋友圈");
                    Toast.makeText(getApplicationContext(), "发送到微信朋友圈", Toast.LENGTH_SHORT).show();
                    WXWebpageObject webpage2 = new WXWebpageObject();
                    webpage2.webpageUrl = webView1.getUrl();
                    WXMediaMessage msg2 = new WXMediaMessage(webpage2);
                    msg2.title = webView1.getTitle();
                    msg2.description = "安浪创想网：从事互联网技术产品开发，专注于信息技术领域的高端商业资源开发，技术型、创新型、公益性网站，欢迎合作、共赢！";
                    Bitmap thumb2 = BitmapFactory.decodeResource(getResources(), R.drawable.send_music_thumb);
                    msg2.thumbData = Util.bmpToByteArray(thumb2, true);
                    SendMessageToWX.Req req2 = new SendMessageToWX.Req();
                    req2.transaction = buildTransaction("webpage");
                    req2.message = msg2;
                    req2.scene = SendMessageToWX.Req.WXSceneTimeline;
                    api.sendReq(req2);
//                finish();
                }
                break;
                case R.id.btn_qr_scan: {
                    Log.d("按钮", "扫一扫");
                    Toast.makeText(getApplicationContext(), "扫一扫", Toast.LENGTH_SHORT).show();
                    Intent goQRCode = new Intent(QRwebActivity.this, ScannerActivity.class);
                    startActivity(goQRCode);
                }
                break;
                case R.id.btn_voice:
                    Log.d("按钮", "语音识别");
                    Toast.makeText(getApplicationContext(), "语音识别", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_face_scan:
                    Log.d("按钮", "人脸识别");
                    Toast.makeText(getApplicationContext(), "人脸识别", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {

            //当动画都结束的时候才可以操作
            if (AnimUtil.animCount != 0) {
                return true;
            }
            if (isShowMenu) {
                // 需要关闭所有菜单
                int startOffset = 0;
                if (isShowLevel3) {
                    AnimUtil.showOrChoseMenu(level3, startOffset, false);
                    isShowLevel3 = false;
                    startOffset += 200;
                }
                if (isShowLevel2) {
                    AnimUtil.showOrChoseMenu(level2, startOffset, false);
                    isShowLevel2 = false;
                    startOffset += 200;
                }

                AnimUtil.showOrChoseMenu(level1, startOffset, false);

            } else {
                // 需要显示所有菜单
                AnimUtil.showOrChoseMenu(level1, 0, true);
                AnimUtil.showOrChoseMenu(level2, 200, true);
                isShowLevel2 = true;
                AnimUtil.showOrChoseMenu(level3, 400, true);
                isShowLevel3 = true;

            }
            isShowMenu = !isShowMenu;

            return true;
        }

//        返回键推出代码
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QRwebActivity.this);
            builder.setMessage("您要退出安浪创想客户端吗？");
            builder.setTitle(R.string.app_name);
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
            return true;
        }//退出代码结束

        return super.onKeyDown(keyCode, event);
    }


    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}