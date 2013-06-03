package com.viewpagerindicator.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.truba.touchgallery.GalleryWidget.BasePagerAdapter;
import ru.truba.touchgallery.GalleryWidget.GalleryViewPager;
import ru.truba.touchgallery.GalleryWidget.UrlPagerAdapter;

public class SampleCirclesDefault extends BaseSampleActivity {

    UninterceptableViewPager mPager;
    SamplePagerAdapter mPagerAdapter;

    private GalleryViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);

//        mPagerAdapter = new SamplePagerAdapter(getSupportFragmentManager());
//
//        mPager = (UninterceptableViewPager)findViewById(R.id.pager);
//        mPager.setAdapter(mPagerAdapter);
//
//        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
//        mIndicator.setViewPager(mPager);


        String[] urls = {
                "http://cs407831.userapi.com/v407831207/18f6/jBaVZFDhXRA.jpg",
                "http://cs407831.userapi.com/v4078f31207/18fe/4Tz8av5Hlvo.jpg",
                "http://cs407831.userapi.com/v407831207/1906/oxoP6URjFtA.jpg",
                "http://cs407831.userapi.com/v407831207/190e/2Sz9A774hUc.jpg",
                "http://cs407831.userapi.com/v407831207/1916/Ua52RjnKqjk.jpg",
                "http://cs407831.userapi.com/v407831207/191e/QEQE83Ok0lQ.jpg"
        };
        List<String> items = new ArrayList<String>();
        Collections.addAll(items, urls);

        UrlPagerAdapter pagerAdapter = new UrlPagerAdapter(this, items);
        pagerAdapter.setOnItemChangeListener(new BasePagerAdapter.OnItemChangeListener()
        {
            @Override
            public void onItemChange(int currentPosition)
            {
                Toast.makeText(SampleCirclesDefault.this, "Current item is " + currentPosition, Toast.LENGTH_SHORT).show();
            }
        });

        mPager = (UninterceptableViewPager)findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(3);
        mPager.setAdapter(pagerAdapter);


        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mViewPager);

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