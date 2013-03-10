package com.example.asdfsdf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class FragmentTest extends Fragment {
    public static final String ARG_PAGE = "pager";
    private int index;

    public static Fragment newInstance(int index) {
        FragmentTest frgment = new FragmentTest();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, index);
        frgment.setArguments(bundle);
        return frgment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;

        if (index == 0)
            v = inflater.inflate(R.layout.a, container, false);
        if (index == 1)
            v = inflater.inflate(R.layout.b, container, false);
        if (index == 2)
            v = inflater.inflate(R.layout.c, container, false);

        return v;
    }


}
