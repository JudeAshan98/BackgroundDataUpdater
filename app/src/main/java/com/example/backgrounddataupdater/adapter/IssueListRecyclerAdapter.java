/*
package com.example.backgrounddataupdater.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgrounddataupdater.MainActivity;
import com.example.backgrounddataupdater.R;
import com.example.backgrounddataupdater.models.StockTransferRMHeaderModel;
import com.example.backgrounddataupdater.util.Utility;

import java.util.List;

public class IssueListRecyclerAdapter extends RecyclerView.Adapter<IssueListRecyclerAdapter.IssueListViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<StockTransferRMHeaderModel> stockTransferRMHeaderModel;

    public IssueListRecyclerAdapter(Context context, List<StockTransferRMHeaderModel> stockTransferRMHeaderModel) {
        this.context = context;
        this.stockTransferRMHeaderModel = stockTransferRMHeaderModel;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public IssueListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.issue_list_row_select, parent, false);
        return new IssueListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueListViewHolder holder, int position) {
        StockTransferRMHeaderModel StockRMHeader = stockTransferRMHeaderModel.get(position);

        holder.trans_text.setText(""+ StockRMHeader.getTransferNo());
        holder.narration_text.setText(""+ StockRMHeader.getNarration());
        holder.move_date_text.setText(Utility.convertDate(StockRMHeader.getMoveDate()));
        holder.trans_text.setTag(StockRMHeader);
        holder.issue_pick_item.setTag(holder);
        holder.issue_pick_item.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        if (stockTransferRMHeaderModel.size() > 0) {
            return stockTransferRMHeaderModel.size();
        } else return 0;
    }

    static class IssueListViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {
        TextView trans_text, narration_text, move_date_text;
        CardView issue_pick_item;

        public IssueListViewHolder(@NonNull View itemView) {
            super(itemView);
            trans_text     = (TextView) itemView.findViewById(R.id.trans_text);
            narration_text = (TextView) itemView.findViewById(R.id.narration_text);
            move_date_text = (TextView) itemView.findViewById(R.id.move_date_text);
            issue_pick_item = (CardView) itemView.findViewById(R.id.issue_pick_item);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            IssueListViewHolder viewholder = (IssueListViewHolder) view.getTag();
            StockTransferRMHeaderModel HeaderObj = ((StockTransferRMHeaderModel) viewholder.trans_text.getTag());
            Intent mIntent = new Intent(context, MainActivity.class);
            Bundle mBundle = new Bundle();
            mBundle.putSerializable("Issue_Header", HeaderObj);
            mIntent.putExtras(mBundle);
            context.startActivity(mIntent);
        }
    };
}
*/
