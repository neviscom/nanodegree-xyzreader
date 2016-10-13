package com.example.xyzreader.utils;

import android.support.annotation.NonNull;
import android.text.Html;

/**
 * @author Nikita Simonov
 */

public final class HtmlUtils {

    private HtmlUtils() {
    }

    @NonNull
    public static CharSequence fromHtml(@NonNull String text) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            //noinspection deprecation
            return Html.fromHtml(text);
        }
    }
}
