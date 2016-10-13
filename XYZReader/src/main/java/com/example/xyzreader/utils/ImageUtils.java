package com.example.xyzreader.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author Nikita Simonov
 */

public final class ImageUtils {

    private ImageUtils() {
    }

    public static void loadImage(@NonNull Context context,
                                 @NonNull ImageView imageView, @NonNull String url) {
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }

}
