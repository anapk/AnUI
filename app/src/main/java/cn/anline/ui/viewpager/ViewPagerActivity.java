package cn.anline.ui.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.anline.ui.R;
import cn.anline.ui.viewpager.view.ViewPagerIndicator;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;

    private List<String> mTitles = Arrays.asList("短信","收藏","推荐");
    private List<ViewSimpleFragment> mContents = new ArrayList<ViewSimpleFragment>();
    private FragmentPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_pager);

        initViews();
        initDatas();
          mViewPager.setAdapter(mAdapter);
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager1);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);
    }

    private void initDatas(){
        for(String title:mTitles){
            ViewSimpleFragment fragment = ViewSimpleFragment.newInstance(title);
            mContents.add(fragment);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };
    }
}
