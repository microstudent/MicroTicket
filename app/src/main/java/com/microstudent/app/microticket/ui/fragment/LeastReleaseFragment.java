package com.microstudent.app.microticket.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.microstudent.app.colorfulanimview.AnimProgressDialog;
import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.model.entity.Movie;
import com.microstudent.app.microticket.presenter.LeastReleasePresenter;
import com.microstudent.app.microticket.presenter.impl.LeastReleasePresenterImpl;
import com.microstudent.app.microticket.ui.view.LeastReleaseView;

import java.util.List;


public class LeastReleaseFragment extends Fragment implements LeastReleaseView{
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_cityID = "cityId";

    private int mCityID;

    private  LeastReleasePresenter presenter;

    private AnimProgressDialog progressDialog;//载入窗口

    public LeastReleaseFragment() {
        // Required empty public constructor
    }

    public static LeastReleaseFragment newInstance(int cityID) {
        LeastReleaseFragment fragment = new LeastReleaseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_cityID, cityID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCityID = getArguments().getInt(ARG_cityID);
        }
        presenter = new LeastReleasePresenterImpl(this);
        presenter.loadData(210);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_least_release, container, false);
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
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setMoviesData(List<Movie> movies) {

    }
}
