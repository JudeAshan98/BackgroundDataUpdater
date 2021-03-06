package com.example.backgrounddataupdater;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgrounddataupdater.adapter.OnlineVotesAdapter;
import com.example.backgrounddataupdater.database.PeercoreDatabase;
import com.example.backgrounddataupdater.models.VoteModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class OnlineActivity extends AppCompatActivity {
    PeercoreDatabase peercoreDatabase;
    List<VoteModel> VoteModels = new ArrayList<VoteModel>();
    VoteModel voteModel = new VoteModel();
    RecyclerView MainRecyclerView;
    OnlineVotesAdapter OnlineVotesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_votes);


        PeercoreDatabase.getInstance(OnlineActivity.this);
        PeercoreDatabase.getInstance(OnlineActivity.this);
        initializeVies();

        displayList();

    }
/*
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
    }*/

    private void displayList() {
        peercoreDatabase = PeercoreDatabase.getInstance(OnlineActivity.this);
        new RetrieveTask(this).execute();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerView recyclerView = findViewById(R.id.list_votes3);
        OnlineVotesAdapter adapter = new OnlineVotesAdapter(OnlineActivity.this, VoteModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(OnlineActivity.this));
        recyclerView.setAdapter(adapter);
    }

    private static class RetrieveTask extends AsyncTask<Void, Void, List<VoteModel>> {

        private WeakReference<OnlineActivity> activityReference;

        // only retain a weak reference to the activity
        RetrieveTask(OnlineActivity context) {
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

    private void initializeVies() {

        MainRecyclerView = findViewById(R.id.list_votes3);
        MainRecyclerView.setLayoutManager(new LinearLayoutManager((OnlineActivity.this)));
        VoteModels = new ArrayList<>();
        OnlineVotesAdapter = new OnlineVotesAdapter(OnlineActivity.this, VoteModels);
        MainRecyclerView.setAdapter(OnlineVotesAdapter);
    }
}
