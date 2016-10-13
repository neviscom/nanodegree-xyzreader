package com.example.xyzreader.ui.articleList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xyzreader.R;

/**
 * @author Nikita Simonov
 */
class CardViewHolder extends RecyclerView.ViewHolder {

    DynamicHeightImageView thumbnailView;
    TextView titleView;
    TextView subtitleView;

    CardViewHolder(View view) {
        super(view);
        thumbnailView = (DynamicHeightImageView) view.findViewById(R.id.thumbnail);
        titleView = (TextView) view.findViewById(R.id.article_title);
        subtitleView = (TextView) view.findViewById(R.id.article_subtitle);
    }
}
