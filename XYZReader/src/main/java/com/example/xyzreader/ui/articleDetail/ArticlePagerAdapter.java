package com.example.xyzreader.ui.articleDetail;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.example.xyzreader.data.ArticleLoader;

/**
 * @author Nikita Simonov
 */

class ArticlePagerAdapter extends FragmentStatePagerAdapter {

    @Nullable
    private Cursor mCursor;

    ArticlePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    void setCursor(@Nullable Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        if (mCursor == null) {
            return null;
        }
        mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(mCursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }
}
