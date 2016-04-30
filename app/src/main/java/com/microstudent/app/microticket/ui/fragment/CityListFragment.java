package com.microstudent.app.microticket.ui.fragment;


import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microstudent.app.bouncyfastscroller.vertical.VerticalBouncyFastScroller;
import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.CityListAdapter;
import com.microstudent.app.microticket.adapter.MoviesAdapter;
import com.microstudent.app.microticket.presenter.impl.CityListPresenterImpl;
import com.microstudent.app.microticket.ui.common.BaseFragment;

public class CityListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private CityListPresenterImpl mPresenter;
    private VerticalBouncyFastScroller mScroller;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_city_list;
    }

    @Override
    protected void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        mPresenter = new CityListPresenterImpl(this);
        mScroller = (VerticalBouncyFastScroller) view.findViewById(R.id.vbfs);
    }

    @Override
    protected void setupViews(Bundle bundle) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
        mPresenter.loadData();
        mScroller.setRecyclerView(mRecyclerView);
    }


    public void setData(Object[] data) {
        if (data != null) {
            mScroller.setData(data);
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
}
