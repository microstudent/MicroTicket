package com.microstudent.app.microticket.ui.activity;



import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.ui.common.BaseActivity;
import com.microstudent.app.microticket.ui.fragment.CityListFragment;
import com.microstudent.app.microticket.ui.fragment.LeastReleaseFragment;


public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private FrameLayout fragmentContainer;

    @Override
    protected void setupView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new CityListFragment()).commit();
        }
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
