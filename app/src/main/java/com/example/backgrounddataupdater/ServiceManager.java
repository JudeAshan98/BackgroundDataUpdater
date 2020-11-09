package com.example.backgrounddataupdater;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ServiceManager {
    public ServiceManager(Context context) {
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private Object getSystemService(String connectivityService) {
        return connectivityService;
    }
}
