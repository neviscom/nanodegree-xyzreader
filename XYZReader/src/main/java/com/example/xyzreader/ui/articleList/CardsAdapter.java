package com.example.xyzreader.ui.articleList;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ArticleLoader;

/**
 * @author Nikita Simonov
 */

class CardsAdapter extends RecyclerView.Adapter<CardViewHolder> {

    @NonNull
    private final Cursor mCursor;

    @Nullable
    private OnCardClickListener mOnCardClickListener;

    CardsAdapter(@NonNull Cursor cursor) {
        mCursor = cursor;
    }

    @Override
    public long getItemId(int position) {
        mCursor.moveToPosition(position);
        return mCursor.getLong(ArticleLoader.Query._ID);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_article, parent, false);
        final CardViewHolder vh = new CardViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnCardClickListener != null) {
                    mOnCardClickListener.onCardClick(getItemId(vh.getAdapterPosition()));
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.bindView(mCursor);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    void setOnCardClickListener(@Nullable OnCardClickListener onCardClickListener) {
        mOnCardClickListener = onCardClickListener;
    }

    interface OnCardClickListener {
        void onCardClick(long itemId);
    }
}
