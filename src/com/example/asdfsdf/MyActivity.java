package com.example.asdfsdf;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        activity = this;

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onPageSelected(int i) {
                FragmentManager manager = getSupportFragmentManager();
//                Fragment fragment = manager.findFragmentByTag( "android:switcher:"+R.id.pager+":"+i);
                Fragment fragment = FragmentTest.newInstance(0);

                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.pager, fragment);

                transaction.commit();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private String getFragmentTag(int viewID, int position) {
        return "android:switcher:" + viewID + ":" + position;
    }
}
