package com.example.backgrounddataupdater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.backgrounddataupdater.BuildConfig;
import com.example.backgrounddataupdater.models.NetworkModel;

public class ConnectionService extends BroadcastReceiver {

    // String constant that defines the custom broadcast Action.

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    NetworkModel networkModel = new NetworkModel();

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();


        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            // is not empty, start a FetchBook AsyncTask.
            // Check the status of the network connection.
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (connMgr != null) {
                networkInfo = connMgr.getActiveNetworkInfo();
//            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show();
            }

            if (networkInfo != null && networkInfo.isConnected()) {
                networkModel.setStatus("ON");
                toastMessage = "Active Internet Connection";
            }
            else {
                networkModel.setStatus("OFF");
                toastMessage = "No Internet Connection";
            }
            //Display the toast.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }

}

