package com.microstudent.app.microticket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.common.BaseRvAdapter;
import com.microstudent.app.microticket.adapter.common.BaseViewHolder;

/**
 * Created by MicroStudent on 2016/4/6.
 */
public class MoviesAdapter extends BaseRvAdapter<MoviesAdapter.MoviesViewHolder> implements BaseViewHolder.OnItemClickListener{

    public MoviesAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_movie, parent, false);
        MoviesViewHolder viewHolder = new MoviesViewHolder(view);
        viewHolder.setOnItemClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void OnItemClick(View view, int position) {

    }

    class MoviesViewHolder extends BaseViewHolder{

        public MoviesViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView(View itemView) {

        }
    }
}
