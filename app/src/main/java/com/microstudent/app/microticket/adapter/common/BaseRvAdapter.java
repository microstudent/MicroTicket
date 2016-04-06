package com.microstudent.app.microticket.adapter.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;


/**
 *
 * Created by 45517 on 2016/3/21.
 */
public abstract class BaseRvAdapter<VH extends BaseViewHolder> extends RecyclerView.Adapter<VH>{
    protected LayoutInflater mInflater;
    protected Context mContext;

    public BaseRvAdapter(Context mContext) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }
}
