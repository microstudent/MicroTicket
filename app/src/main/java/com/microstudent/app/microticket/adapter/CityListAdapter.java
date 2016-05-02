package com.microstudent.app.microticket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.common.BaseRvAdapter;
import com.microstudent.app.microticket.adapter.common.BaseViewHolder;
import com.microstudent.app.microticket.model.entity.City;
import com.microstudent.app.microticket.util.PinyinUtils;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 *
 * Created by MicroStudent on 2016/4/8.
 */
public class CityListAdapter extends BaseRvAdapter<CityListAdapter.CityViewHolder>
        implements StickyRecyclerHeadersAdapter<CityListAdapter.AlphabetViewHolder>{
    public static final String TAG = "CityListAdapter";

    private List<City> mData;

    public CityListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_city, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        Log.d(TAG, "setting text" + position);
        if (holder.mTextView != null) {
            holder.mTextView.setText(mData.get(position).getName());
        }
    }

    @Override
    public long getHeaderId(int position) {
        return mData.get(position).getFirstLetter();
    }

    @Override
    public AlphabetViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.item_header, parent, false);
        return new AlphabetViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(AlphabetViewHolder holder, int position) {
        holder.mTextView.setText(String.valueOf((char) getHeaderId(position)));
    }


    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setDataSet(ArrayList<City> data) {
        this.mData = data;
        Collections.sort(mData);
        notifyDataSetChanged();
    }

    public Object[] getDataSet() {
        if (mData != null) {
            return mData.toArray();
        }
        return null;
    }

    class CityViewHolder extends BaseViewHolder{

        private TextView mTextView;
        public CityViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView(View itemView) {
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    class AlphabetViewHolder extends BaseViewHolder {
        public TextView mTextView;

        public AlphabetViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView(View itemView) {
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
