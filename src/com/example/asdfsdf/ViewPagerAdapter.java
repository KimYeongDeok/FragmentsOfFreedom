package com.example.asdfsdf;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    int id = R.id.pager;
    private FragmentManager fragmentManager;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentTest.newInstance(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    private String getFragmentTag(int position) {
        return "android:switcher:" + id + ":" + position;
    }
}
