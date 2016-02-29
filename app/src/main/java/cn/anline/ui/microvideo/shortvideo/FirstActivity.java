package cn.anline.ui.microvideo.shortvideo;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import cn.anline.ui.R;
import cn.anline.ui.microvideo.fragment.VideoFragment;
import cn.anline.ui.microvideo.utils.Utils;


public class FirstActivity extends ActionBarActivity {
    // 录制按钮
    private Button btnRecordAudio;
    // 播放按钮
    private ImageButton btnPlay;
    // 文件路径
    private String path = "";

    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_video_first);

        btnRecordAudio = (Button) findViewById(R.id.btn_record_audio);
        btnPlay = (ImageButton) findViewById(R.id.play);
		File filePathFile = new File("/storage/emulated/0/AnUI/video/");
		if (filePathFile != null &&filePathFile.listFiles()!=null) {
			if (filePathFile.listFiles().length > 0) {
				path = filePathFile.listFiles()[0].getPath();
				Bitmap bitmap = Utils.createVideoThumbnail(path);
				BitmapDrawable drawable = new BitmapDrawable(bitmap);
				drawable.setTileModeXY(Shader.TileMode.REPEAT,
						Shader.TileMode.REPEAT);
				drawable.setDither(true);
				btnPlay.setBackgroundDrawable(drawable);
			}
		}
		btnRecordAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动拍摄的Activity
                Intent intent = new Intent(FirstActivity.this,VideoActivity.class);
                FirstActivity.this.startActivityForResult(intent,200);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("NewApi")
			@Override
            public void onClick(View v) {
                // 显示播放页面
				if (path!=null&&!path.equalsIgnoreCase("")) {
	                VideoFragment bigPic = VideoFragment.newInstance(path);
	                android.app.FragmentManager mFragmentManager = getFragmentManager();
	                FragmentTransaction transaction = mFragmentManager.beginTransaction();
	                transaction.replace(R.id.main_menu, bigPic);
	                transaction.commit();
				}
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.micro_video_menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 200:
                if(resultCode == RESULT_OK) {
                    // 成功
                    path = data.getStringExtra("path");
                    Toast.makeText(FirstActivity.this,"存储路径为:"+path,Toast.LENGTH_SHORT).show();
                    // 通过路径获取第一帧的缩略图并显示
                    Bitmap bitmap = Utils.createVideoThumbnail(path);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    drawable.setTileModeXY(Shader.TileMode.REPEAT , Shader.TileMode.REPEAT);
                    drawable.setDither(true);
                    btnPlay.setBackgroundDrawable(drawable);
                } else {
                    // 失败
                }
                break;

        }
    }
}
