package com.microstudent.app.microticket.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.CityListAdapter;
import com.microstudent.app.microticket.adapter.MoviesAdapter;
import com.microstudent.app.microticket.presenter.impl.CityListPresenterImpl;
import com.microstudent.app.microticket.ui.common.BaseFragment;

public class CityListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private CityListPresenterImpl mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_city_list;
    }

    @Override
    protected void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        mPresenter = new CityListPresenterImpl(this);
    }

    @Override
    protected void setupViews(Bundle bundle) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mPresenter.loadData();
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
