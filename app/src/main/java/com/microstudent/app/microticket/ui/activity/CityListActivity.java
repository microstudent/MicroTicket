package com.microstudent.app.microticket.ui.activity;

import android.app.SearchManager;
import android.graphics.Canvas;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.microstudent.app.bouncyfastscroller.vertical.VerticalBouncyFastScroller;
import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.CityListAdapter;
import com.microstudent.app.microticket.presenter.impl.CityListPresenterImpl;
import com.microstudent.app.microticket.ui.common.BaseActivity;

public class CityListActivity extends BaseActivity{
    private RecyclerView mRecyclerView;
    private CityListPresenterImpl mPresenter;
    private VerticalBouncyFastScroller mScroller;
    private Toolbar mToolbar;

    @Override
    protected void setupView(Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mScroller.setRecyclerView(mRecyclerView);
        mPresenter.loadData();
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        mPresenter = new CityListPresenterImpl(this);
        mScroller = (VerticalBouncyFastScroller) findViewById(R.id.vbfs);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_city_list;
    }

    public void setData(Object[] data) {
        if (data != null) {
            mScroller.setData(data);
        }
    }


    public void setItemDecoration(RecyclerView.ItemDecoration decoration) {
        if (decoration != null) {
            mRecyclerView.addItemDecoration(decoration);
        }
    }

    public void setAdapter(CityListAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.citylist_menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(mPresenter);
        return true;
    }

    public void scrollToPosition(int i) {
        mRecyclerView.scrollToPosition(i);
    }
}
