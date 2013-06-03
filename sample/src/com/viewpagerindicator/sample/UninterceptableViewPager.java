package com.viewpagerindicator.sample;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import ru.truba.touchgallery.GalleryWidget.GalleryViewPager;

/**
 * Created by jin on 13. 5. 31..
 */
public class UninterceptableViewPager extends GalleryViewPager {

    public UninterceptableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Tell our parent to stop intercepting our events!
        boolean ret = super.onInterceptTouchEvent(ev);
        if (ret) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ret;
    }
}