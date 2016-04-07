package com.microstudent.app.microticket.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.microstudent.app.colorfulanimview.AnimProgressDialog;
import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.common.BaseRvAdapter;
import com.microstudent.app.microticket.api.APIList;
import com.microstudent.app.microticket.api.CityAPI;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.presenter.LeastReleasePresenter;
import com.microstudent.app.microticket.presenter.impl.LeastReleasePresenterImpl;
import com.microstudent.app.microticket.ui.common.BaseFragment;
import com.microstudent.app.microticket.ui.view.LeastReleaseView;

import java.io.IOException;
import java.util.List;


public class LeastReleaseFragment extends BaseFragment implements LeastReleaseView{
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_cityID = "cityId";

    private int mCityID;//当前城市ID

    private RecyclerView recyclerView;

    private  LeastReleasePresenter presenter;

    private AnimProgressDialog progressDialog;//载入窗口

    public static LeastReleaseFragment newInstance(int cityID) {
        LeastReleaseFragment fragment = new LeastReleaseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_cityID, cityID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_least_release;
    }

    @Override
    protected void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
    }

    @Override
    protected void setupViews(Bundle bundle) {
        if (getArguments() != null) {
            mCityID = getArguments().getInt(ARG_cityID);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        presenter = new LeastReleasePresenterImpl(this);
        presenter.loadData(210);
    }

    @Override
    public void setAdapter(BaseRvAdapter adapter) {
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void showLoading() {
        progressDialog = new AnimProgressDialog(getContext());
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.cancel();
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    public void setMoviesData(List<Movie> movies) {

    }
}
