package com.viewpagerindicator.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class SampleCirclesDefault extends BaseSampleActivity {

    UninterceptableViewPager mPager;
    SamplePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);

        mPagerAdapter = new SamplePagerAdapter(getSupportFragmentManager());

        mPager = (UninterceptableViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }

    static class SamplePagerAdapter extends FragmentPagerAdapter {
    private int mCount = 6;

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Fragment getItem(int i) {
            return new PhotoFragment();
        }
    }
}