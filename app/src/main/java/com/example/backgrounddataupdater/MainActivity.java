package com.example.backgrounddataupdater;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgrounddataupdater.adapter.OnlineVotesAdapter;
import com.example.backgrounddataupdater.database.PeercoreDatabase;
import com.example.backgrounddataupdater.models.VoteModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
    Author : Jude Ashan Lakmal
    Date   : 27th of 2020
    Task   : Room DB + Background services + Broadcast Receivers
    Company: Peercore Nexgen Software.
*/


public class MainActivity extends AppCompatActivity {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    List<VoteModel> VoteModels = new ArrayList<VoteModel>();
    PeercoreDatabase peercoreDatabase;
    Button submit, clear, Online, Offline;
    EditText fname, lname, mobile, Vote, city, comment;
    Spinner province;
    VoteModel voteModel = new VoteModel();
    private CustomReceiver mReceiver = new CustomReceiver();
    private String Con_status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeercoreDatabase.getInstance(MainActivity.this);

        peercoreDatabase = PeercoreDatabase.getInstance(MainActivity.this);

        //Edit texts
        fname = findViewById(R.id.fName);
        lname = findViewById(R.id.lName);
        mobile = findViewById(R.id.mobile);
        Vote = findViewById(R.id.Vote);
        city = findViewById(R.id.city);
        province = findViewById(R.id.province);
        comment = findViewById(R.id.comment);

        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.Clear);
        Online = findViewById(R.id.online);
        Offline = findViewById(R.id.offline);

        Con_status = mReceiver.Status;

        // Broadcast Receiver - Start
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);


        // Register the receiver using the activity context.
        this.registerReceiver(mReceiver, filter);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));


        // Broadcast Receiver - End


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormClear();
            }
        });

        Offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OfflineActivity.class);
                startActivity(intent);

            }
        });

        Online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OnlineActivity.class);
                startActivity(intent);

            }
        });
    }

    private void FormClear() {
        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG).show();

        fname.setText("");
        lname.setText("");
        mobile.setText("");
        Vote.setText("");
        city.setText("");
        comment.setText("");
    }

    private void Validation() {

        if (fname.getText().length() == 0) {
            fname.setError("Fist Name !!");
            fname.setHintTextColor(getResources().getColor(R.color.red));
            return;
        }
        if (lname.getText().length() == 0) {
            lname.setError("Last Name !!");
            lname.setHintTextColor(getResources().getColor(R.color.red));
            return;
        }
        if (mobile.getText().length() == 0) {
            mobile.setError("Mobile Number !!");
            mobile.setHintTextColor(getResources().getColor(R.color.red));
            return;
        }
        if (city.getText().length() == 0) {
            city.setError("City !!");
            city.setHintTextColor(getResources().getColor(R.color.red));
            return;
        }
        if (Vote.getText().length() == 0) {
            Vote.setError("Vote !!");
            Vote.setHintTextColor(getResources().getColor(R.color.red));
            return;
        }
       /* if ((Vote.getText().length() > 0) && !((Vote.getText().equals(71))||(Vote.getText().equals(77))||
                (Vote.getText().equals(75))||
                (Vote.getText().equals(78)))){
            Vote.setError("Invalid Vote !!");
            Vote.setTextColor(getResources().getColor(R.color.red));
            return;
        }*/
        SaveDataToDB();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode > 0) {
            if (resultCode == 1) {
                VoteModels.add((VoteModel) data.getSerializableExtra("Zone"));
            } else if (resultCode == 2) {
                int pos = 0;
                VoteModels.set(pos, (VoteModel) data.getSerializableExtra("Zone"));
            }
            displayList();
        }
    }

    private void displayList() {
        peercoreDatabase = PeercoreDatabase.getInstance(MainActivity.this);
        new RetrieveTask(this).execute();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerView recyclerView = findViewById(R.id.list_votes);
        OnlineVotesAdapter adapter = new OnlineVotesAdapter(MainActivity.this, VoteModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        //Unregister the receiver
        this.unregisterReceiver(mReceiver);
        super.onDestroy();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);

    }

    private void setResult(VoteModel Vote, int flag) {
        setResult(flag, new Intent().putExtra("Zones", String.valueOf(Vote)));
        //  finish();
    }

    private void SaveDataToDB() {
        VoteModel voteModel = new VoteModel();

        voteModel.setFname(fname.getText().toString());
        voteModel.setLname(lname.getText().toString());
        voteModel.setMobile(mobile.getText().toString() + "");
        voteModel.setVote(Integer.parseInt(Vote.getText().toString()));
        voteModel.setProvince(province.getPrompt().toString());
        voteModel.setCity(city.getText().toString());
        voteModel.setComment(comment.getText().toString() + "");
        voteModel.setCon_status(Con_status);

        new InsertZone(MainActivity.this, voteModel).execute();
        peercoreDatabase.getVotes().insertVote(voteModel);
        Toast.makeText(MainActivity.this, "Vote Success", Toast.LENGTH_LONG).show();
        FormClear();
    }

    private static class InsertZone extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<MainActivity> activityReference;
        private VoteModel Zone;

        // only retain a weak reference to the activity
        InsertZone(MainActivity context, VoteModel note) {
            activityReference = new WeakReference<>(context);
            this.Zone = note;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            // retrieve auto incremented zone id
//               long j = activityReference.get().peercoreDatabase.getVotes().insertVote(Zone);
//              Zone.setVote_id(j);
            //  Log.e("ID ", "doInBackground: " + j);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool) {
                activityReference.get().setResult(Zone, 1);
                //   activityReference.get().finish();
            }
        }
    }

    private static class RetrieveTask extends AsyncTask<Void, Void, List<VoteModel>> {

        private WeakReference<MainActivity> activityReference;

        // only retain a weak reference to the activity
        RetrieveTask(MainActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected List<VoteModel> doInBackground(Void... voids) {
            if (activityReference.get() != null)
                return activityReference.get().peercoreDatabase.getVotes().getVotes();
            else
                return null;
        }

        @Override
        protected void onPostExecute(List<VoteModel> notes) {
            if (notes != null && notes.size() > 0) {
                activityReference.get().VoteModels.clear();
                activityReference.get().VoteModels.addAll(notes);
            }
        }


    }
}
