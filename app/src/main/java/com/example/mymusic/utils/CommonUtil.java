package com.example.mymusic.utils;

import android.text.Html;
import android.widget.TextView;

/**
 * Created by SJC on 2020/4/25.
 * Describe：
 */
public class CommonUtil {

    public static final int SongResultType = 1;
    public static final int AlbumResultType = 2;
    public static final int AlbumInfoType = 3;

    /**
     * 使指定的字符串显示不同的颜色
     */
    public static void showStringColor(String appointStr, String originalStr, TextView textView) {
        originalStr = originalStr.replaceAll(appointStr, "<font color='#FFC66D'>" + appointStr + "</font>");
        textView.setText(Html.fromHtml(originalStr));
    }
}
