package com.microstudent.app.microticket.presenter.impl;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.microstudent.app.microticket.adapter.CityListAdapter;
import com.microstudent.app.microticket.model.OnLoadingCompleteListener;
import com.microstudent.app.microticket.model.entity.City;
import com.microstudent.app.microticket.model.impl.CityModelImpl;
import com.microstudent.app.microticket.ui.activity.CityListActivity;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by MicroStudent on 2016/4/8.
 */
public class CityListPresenterImpl implements OnLoadingCompleteListener<ArrayList<City>>{
    private static final String TAG = "CityListPresenterImpl";
    private CityModelImpl mModel;
    private CityListActivity mView;
    private CityListAdapter mAdapter;

    public CityListPresenterImpl(CityListActivity mView) {
        this.mView = mView;
        mModel = new CityModelImpl();
        mAdapter = new CityListAdapter(mView);
    }


    public void loadData() {
        mModel.getCity(this);
    }

    public Object[] getCityArray() {
        return mAdapter.getDataSet();
    }

    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onSuccess(ArrayList<City> data) {
        Log.d(TAG, "（onSuccess）In UI thread? "+ String.valueOf(Looper.getMainLooper() == Looper.myLooper()));
        mAdapter.setDataSet(data);
        mView.setAdapter(mAdapter);

        mView.setData(getCityArray());
        mView.setItemDecoration(new StickyRecyclerHeadersDecoration(mAdapter));
    }

    @Override
    public void onFailure(String msg) {
        Log.d(TAG, "（onFail）In UI thread? "+ String.valueOf(Looper.getMainLooper() == Looper.myLooper()));

        Toast.makeText(mView, msg, Toast.LENGTH_SHORT).show();
    }
}
