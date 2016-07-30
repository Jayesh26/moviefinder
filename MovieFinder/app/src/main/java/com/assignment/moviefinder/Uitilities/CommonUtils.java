package com.assignment.moviefinder.Uitilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * common utility method
 *
 * @Author jayesh
 * @Since 29/7/16.
 */
public class CommonUtils {


    /**
     * Checks if device has active internet connection
     *
     * @param context the context of application
     * @return true if connected, false otherwise
     */
    public static boolean hasActiveInternetConnection(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
