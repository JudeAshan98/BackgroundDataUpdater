/*
package com.example.backgrounddataupdater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbapi.R;
import com.example.roomdbapi.models.RackingZoneModel;

import java.util.List;

public class ZonesAdapter extends RecyclerView.Adapter<ZonesAdapter.ZoneViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<RackingZoneModel> rackingZoneModels;
    private OnItemClick onItemClick;


    public ZonesAdapter(Context context,List<RackingZoneModel> RackingZoneModel) {
        this.context = context;
        this.rackingZoneModels = RackingZoneModel;
        this.onItemClick = (OnItemClick) context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ZoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.trackingtemp, parent, false);
        return new ZoneViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ZoneViewHolder holder, int position) {
        RackingZoneModel rackingZoneModel = rackingZoneModels.get(position);

        holder.code_text.setText("" + rackingZoneModel.getCode());
        holder.desc_text.setText("" + rackingZoneModel.getDescription());
        holder.code_text.setTag(rackingZoneModel);
        holder.Zone_pick_item.setTag(holder);
    }

    @Override
    public int getItemCount() {
        if (rackingZoneModels.size() > 0) {
            return rackingZoneModels.size();
        } else return 0;
    }

    public class ZoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView code_text, desc_text;
        CardView Zone_pick_item;

        public ZoneViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            code_text = (TextView) itemView.findViewById(R.id.CodeText);
            desc_text = (TextView) itemView.findViewById(R.id.DescriptionText);
            Zone_pick_item = (CardView) itemView.findViewById(R.id.Zones_pick);
        }

        @Override
        public void onClick(View view) {
             onItemClick.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClick {
        void onItemClick(final int pos);

    }

}

*/
