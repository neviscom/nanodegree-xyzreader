package com.example.xyzreader.ui.articleList;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.utils.ImageUtils;

/**
 * @author Nikita Simonov
 */
class CardViewHolder extends RecyclerView.ViewHolder {

    private DynamicHeightImageView thumbnailView;
    private TextView titleView;
    private TextView subtitleView;

    CardViewHolder(@NonNull View view) {
        super(view);
        thumbnailView = (DynamicHeightImageView) view.findViewById(R.id.thumbnail);
        titleView = (TextView) view.findViewById(R.id.article_title);
        subtitleView = (TextView) view.findViewById(R.id.article_subtitle);
    }

    void bindView(@NonNull Cursor cursor) {
        titleView.setText(cursor.getString(ArticleLoader.Query.TITLE));
        subtitleView.setText(
                DateUtils.getRelativeTimeSpanString(
                        cursor.getLong(ArticleLoader.Query.PUBLISHED_DATE),
                        System.currentTimeMillis(), DateUtils.HOUR_IN_MILLIS,
                        DateUtils.FORMAT_ABBREV_ALL).toString()
                        + " by "
                        + cursor.getString(ArticleLoader.Query.AUTHOR));

        ImageUtils.loadImage(itemView.getContext(), thumbnailView,
                cursor.getString(ArticleLoader.Query.THUMB_URL));
        thumbnailView.setAspectRatio(cursor.getFloat(ArticleLoader.Query.ASPECT_RATIO));
    }
}
