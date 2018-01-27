package com.example.chirusandeep.timetable;

import android.os.Build;

/**
 * Created by chiru sandeep on 1/27/2018.
 */

public class Util {
    public static boolean isOreo() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
