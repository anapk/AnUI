package cn.anline.ui.tabbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.anline.ui.R;
import cn.anline.ui.tabbar.page.TabBarAppstoreActivity;

@SuppressWarnings("deprecation")
public class TabBarActivity extends Activity {
    private ViewPager mTabPager;
    private ImageView mTabLauncher,mTabAppstore,mTabHome,mTabIbook,mTabItunes;
    private int currIndex = 0;// 当前页卡编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);

        mTabPager = (ViewPager)findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());

        mTabLauncher = (ImageView) findViewById(R.id.tab_img_launcher);
        mTabAppstore = (ImageView) findViewById(R.id.tab_img_appstore);
        mTabHome = (ImageView) findViewById(R.id.tab_img_home);
        mTabIbook = (ImageView) findViewById(R.id.tab_img_ibook);
        mTabItunes = (ImageView) findViewById(R.id.tab_img_itunes);
        mTabLauncher .setOnClickListener(new MyOnClickListener(0));
        mTabAppstore.setOnClickListener(new MyOnClickListener(1));
        mTabHome.setOnClickListener(new MyOnClickListener(2));
        mTabIbook.setOnClickListener(new MyOnClickListener(3));
        mTabItunes.setOnClickListener(new MyOnClickListener(4));

        //将要分页显示的View装入数组中
        LayoutInflater mLi = LayoutInflater.from(this);

        View viewLauncher = mLi.inflate(R.layout.activity_tab_bar_launcher, null);
        View viewAppstore = mLi.inflate(R.layout.activity_tab_bar_appstore, null);
        View viewHome = mLi.inflate(R.layout.activity_tab_bar_home, null);
        View viewIbook = mLi.inflate(R.layout.activity_tab_bar_ibook, null);
        View viewItunes = mLi.inflate(R.layout.activity_tab_bar_itunes, null);

        //每个页面的view数据
        final ArrayList<View> views = new ArrayList<View>();
        views.add(viewLauncher);
        views.add(viewAppstore);
        views.add(viewHome);
        views.add(viewIbook);
        views.add(viewItunes);
        //填充ViewPager的数据适配器
        PagerAdapter mPagerAdapter = new PagerAdapter()
        {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                ((ViewPager)container).removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(View container, int position) {
                ((ViewPager)container).addView(views.get(position));
                return views.get(position);
            }
        };
        mTabPager.setAdapter(mPagerAdapter);


        //内页控件监听
    }

    /**
     * 头标点击监听
     */
    public class MyOnClickListener implements View.OnClickListener
    {
        private int index = 0;
        public MyOnClickListener(int i)
        {
            index = i;
        }
        @Override
        public void onClick(View v)
        {
            mTabPager.setCurrentItem(index);
        }
    };

    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener
    {
        @Override
        public void onPageSelected(int arg0)
        {
            switch (arg0)
            {
                case 0:
                {
                    mTabLauncher.setImageDrawable(getResources().getDrawable(R.drawable.tab_launcher_press));
                    if (currIndex == 1)
                    {
                        mTabAppstore.setImageDrawable(getResources().getDrawable(R.drawable.tab_appstore_normal));
                    }
                    else if (currIndex == 2)
                    {
                        mTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_normal));
                    }
                    else if (currIndex == 3)
                    {
                        mTabIbook.setImageDrawable(getResources().getDrawable(R.drawable.tab_ibook_normal));
                    }
                    else if (currIndex == 4)
                    {
                        mTabItunes.setImageDrawable(getResources().getDrawable(R.drawable.tab_itunes_normal));
                    }
                    break;
                }
                case 1:
                {
                    ImageView img1 = (ImageView) findViewById(R.id.imageView2);
                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"图片被点击了",Toast.LENGTH_LONG).show();
                        }
                    });
                    mTabAppstore.setImageDrawable(getResources().getDrawable(R.drawable.tab_appstore_press));
                    if (currIndex == 0)
                    {
                        mTabLauncher.setImageDrawable(getResources().getDrawable(R.drawable.tab_launcher_normal));
                    }
                    else if (currIndex == 2)
                    {
                        mTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_normal));
                    }
                    else if (currIndex == 3)
                    {
                        mTabIbook.setImageDrawable(getResources().getDrawable(R.drawable.tab_ibook_normal));
                    }
                    else if (currIndex == 4)
                    {
                        mTabItunes.setImageDrawable(getResources().getDrawable(R.drawable.tab_itunes_normal));
                    }
                    break;
                }
                case 2:
                {
                    mTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_press));
                    if (currIndex == 0)
                    {
                        mTabLauncher.setImageDrawable(getResources().getDrawable(R.drawable.tab_launcher_normal));
                    }
                    else if (currIndex == 1)
                    {
                        mTabAppstore.setImageDrawable(getResources().getDrawable(R.drawable.tab_appstore_normal));
                    }
                    else if (currIndex == 3)
                    {
                        mTabIbook.setImageDrawable(getResources().getDrawable(R.drawable.tab_ibook_normal));
                    }
                    else if (currIndex == 4)
                    {
                        mTabItunes.setImageDrawable(getResources().getDrawable(R.drawable.tab_itunes_normal));
                    }
                    break;
                }
                case 3:
                {
                    mTabIbook.setImageDrawable(getResources().getDrawable(R.drawable.tab_ibook_press));
                    if (currIndex == 0)
                    {
                        mTabLauncher.setImageDrawable(getResources().getDrawable(R.drawable.tab_launcher_normal));
                    }
                    else if (currIndex == 2)
                    {
                        mTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_normal));
                    }
                    else if (currIndex == 1)
                    {
                        mTabAppstore.setImageDrawable(getResources().getDrawable(R.drawable.tab_appstore_normal));
                    }
                    else if (currIndex == 4)
                    {
                        mTabItunes.setImageDrawable(getResources().getDrawable(R.drawable.tab_itunes_normal));
                    }
                    break;
                }
                case 4:
                {
                    mTabItunes.setImageDrawable(getResources().getDrawable(R.drawable.tab_itunes_press));
                    if (currIndex == 0)
                    {
                        mTabLauncher.setImageDrawable(getResources().getDrawable(R.drawable.tab_launcher_normal));
                    }
                    else if (currIndex == 2)
                    {
                        mTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_normal));
                    }
                    else if (currIndex == 3)
                    {
                        mTabIbook.setImageDrawable(getResources().getDrawable(R.drawable.tab_ibook_normal));
                    }
                    else if (currIndex == 1)
                    {
                        mTabAppstore.setImageDrawable(getResources().getDrawable(R.drawable.tab_appstore_normal));
                    }
                    break;
                }
            }
            currIndex = arg0;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab_bar, menu);
        return true;
    }

}
