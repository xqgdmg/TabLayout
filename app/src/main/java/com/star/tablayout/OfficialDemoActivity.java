package com.star.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.star.tablayout.fragment.Fragment01;
import com.star.tablayout.fragment.Fragment02;

import java.util.ArrayList;

/**
 * Created by qhsj on 2017/9/11.
 */

public class OfficialDemoActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_demo);
        init();
    }

    private void init() {

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            // 用官网的使用方式，必须使用到这个，这个默认返回的是null，也就是不会有任何标题，嵌套没有平级灵活
            @Override
            public CharSequence getPageTitle(int position) {
                return "title" + position;
            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }
}
