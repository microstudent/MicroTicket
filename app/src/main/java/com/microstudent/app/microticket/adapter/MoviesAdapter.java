package com.microstudent.app.microticket.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.microstudent.app.microticket.R;
import com.microstudent.app.microticket.adapter.common.BaseRvAdapter;
import com.microstudent.app.microticket.adapter.common.BaseViewHolder;
import com.microstudent.app.microticket.model.entity.Movie;

import java.util.ArrayList;

/**
 *
 * Created by MicroStudent on 2016/4/6.
 */
public class MoviesAdapter extends BaseRvAdapter<MoviesAdapter.MoviesViewHolder> implements BaseViewHolder.OnItemClickListener{

    private ArrayList<Movie> movies;

    public MoviesAdapter(Context mContext) {
        super(mContext);
    }

    public void setData(ArrayList<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
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
        if (movies != null) {
            Movie movie = movies.get(position);
            holder.iv.setImageURI(Uri.parse(movie.getPoster_url()));
            holder.tv.setText(movie.getName());
        }
    }


    @Override
    public int getItemCount() {
        if (movies != null) {
            return movies.size();
        }
        return 0;
    }

    @Override
    public void OnItemClick(View view, int position) {

    }

    class MoviesViewHolder extends BaseViewHolder{
        private SimpleDraweeView iv;
        private TextView tv;

        public MoviesViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView(View itemView) {
            iv = (SimpleDraweeView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
