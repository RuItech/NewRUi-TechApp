package com.example.ru_itech.CommonUI.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ru_itech.CommonUI.DasboardModel;
import com.example.ru_itech.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.Viewholder> {

    List<DasboardModel> models;
    Context context;

    public DashBoardAdapter(List<DasboardModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        DasboardModel model = models.get(position);
        holder.schoolName.setText(model.getSchool());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i = new Intent(context,school main page);
//                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView schoolName;
        CardView card;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.schoolname);
            card = itemView.findViewById(R.id.card);
        }
    }


}
