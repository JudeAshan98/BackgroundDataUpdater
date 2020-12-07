package com.example.backgrounddataupdater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.backgrounddataupdater.database.PeercoreDatabase;
import com.example.backgrounddataupdater.models.NetworkModel;
import com.example.backgrounddataupdater.models.VoteModel;

public class CustomReceiver extends BroadcastReceiver {
    // String constant that defines the custom broadcast Action.

    PeercoreDatabase peercoreDatabase;
    public String Status="OFF";
    VoteModel voteModel = new VoteModel();
    NetworkModel networkModel = new NetworkModel();
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    networkModel.setStatus("ON");
//                    Status = "ON";
                    voteModel.setCon_status(Status);
                    peercoreDatabase.getVotes().updateVote(voteModel);
                    //setResult(voteModel, 2);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
//                    Status = "OFF";
                    networkModel.setStatus("OFF");
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    break;
            }
            //Display the toast.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }

    private void setResult(VoteModel rackingZoneModel, int i) {
    //    setResult(i, new Intent().putExtra("Zone", rackingZoneModel));

    }
}