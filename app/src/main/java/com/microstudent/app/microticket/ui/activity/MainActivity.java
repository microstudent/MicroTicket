package com.microstudent.app.microticket.ui.activity;



import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.ui.common.BaseActivity;
import com.microstudent.app.microticket.ui.fragment.LeastReleaseFragment;


public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private FrameLayout fragmentContainer;

    @Override
    protected void setupView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, LeastReleaseFragment.newInstance(210)).commit();
        }
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.citylist_menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
