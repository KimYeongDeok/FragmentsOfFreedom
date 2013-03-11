package com.example.asdfsdf;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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


        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        final Handler handler = new Handler();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onPageSelected(final int i) {
                if (i != 1)
                    return;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();

                        Fragment target2 = manager.findFragmentByTag("android:switcher:" + R.id.pager + ":" + i);

                        Fragment fragment = FragmentTest2.newInstance();

                        int id = adapter.getViewID();
                        transaction.replace(id, fragment, "android:switcher:" + R.id.pager + ":" + i);
                        transaction.commit();
                        adapter.notifyDataSetChanged();
                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
