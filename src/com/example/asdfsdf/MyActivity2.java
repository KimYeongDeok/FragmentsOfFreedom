package com.example.asdfsdf;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MyActivity2 extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = FragmentTest.newInstance(2);

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.pager, fragment);

        transaction.commit();


        View view = findViewById(R.id.pager);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();

                Fragment fragment = FragmentTest.newInstance(0);

                FragmentTransaction transaction = manager.beginTransaction();

                transaction.setCustomAnimations(R.anim.slide_in_right,
                		R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
                transaction.addToBackStack(null);
                transaction.replace(R.id.pager, fragment);

                transaction.commit();
            }
        });


    }

    private String getFragmentTag(int viewID, int position) {
        return "android:switcher:" + viewID + ":" + position;
    }
}
