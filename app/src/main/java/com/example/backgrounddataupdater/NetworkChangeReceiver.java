package com.example.backgrounddataupdater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.backgrounddataupdater.models.NetworkModel;

public class NetworkChangeReceiver extends BroadcastReceiver {

    NetworkModel networkModel;

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (checkInternet(context)) {
            Toast.makeText(context, "Network Available Do operations", Toast.LENGTH_LONG).show();
        }
    }

    boolean checkInternet(Context context) {
        ServiceManager serviceManager = new ServiceManager(context);
        if (serviceManager.isNetworkAvailable()) {
            networkModel.setStatus("ON");
            return true;
        } else {
            networkModel.setStatus("OFF");
            return false;
        }
    }
    public boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }

}