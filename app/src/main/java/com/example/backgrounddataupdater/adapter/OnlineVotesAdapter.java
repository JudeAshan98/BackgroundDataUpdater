package com.example.backgrounddataupdater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgrounddataupdater.R;
import com.example.backgrounddataupdater.models.VoteModel;

import java.util.List;

public class OnlineVotesAdapter extends RecyclerView.Adapter<OnlineVotesAdapter.VoteListViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<VoteModel> voteModelList;

    public OnlineVotesAdapter(Context context, List<VoteModel> voteModels) {
        this.context = context;
        this.voteModelList = voteModels;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VoteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.activity_online_votes, parent, false);
        return new VoteListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VoteListViewHolder holder, int position) {
        VoteModel voteModel = voteModelList.get(position);

        holder.id_text.setText("" + voteModel.getVote_id());
        holder.vote_text.setText("" + voteModel.getVote());
        holder.name_text.setText(""+voteModel.getFname());
        holder.status.setText(""+voteModel.getCon_status());
        holder.id_text.setTag(voteModel);
        holder.id_text.setTag(holder);
    }

    @Override
    public int getItemCount() {

        if (voteModelList.size() > 0) {
            return voteModelList.size();
        } else return 0;
    }

    static class VoteListViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {
        TextView id_text, vote_text, name_text,status;
        CardView list_card;

        public VoteListViewHolder(@NonNull View itemView) {

            super(itemView);
//            itemView.setOnClickListener(this);
            id_text = (TextView) itemView.findViewById(R.id.VoteID);
            vote_text = (TextView) itemView.findViewById(R.id.Vote);
            name_text = (TextView) itemView.findViewById(R.id.fName);
            status = (TextView) itemView.findViewById(R.id.Status);
            list_card = (CardView) itemView.findViewById(R.id.vote_pick_item);

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }
}