package com.example.ru_itech.CommonUI.Adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ru_itech.CommonUI.DasboardModel;
import com.example.ru_itech.CommonUI.UI.CommonNewsPage;
import com.example.ru_itech.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.Viewholder> {

    List<DasboardModel> models;
    public boolean on_attach = true;
    Context context;

    public DashBoardAdapter(List<DasboardModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final DasboardModel model = models.get(position);
        holder.schoolName.setText(model.getSchool());

        Picasso.with(context
        ).load(model.getLogo()).into(holder.image);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, CommonNewsPage.class);
                i.putExtra("School",model.getSchool());
                context.startActivity(i);
            }
        });

        RightLeft(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView schoolName;
        CardView card;
        ImageView image;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.schoolname);
            card = itemView.findViewById(R.id.card);
            image = itemView.findViewById(R.id.imagec);
        }
    }

    public void RightLeft(View itemview, int i) {
        if (!on_attach) {
            i = -1;
        }


        boolean isNotFirst = i == -1;
        i = i + 1;
        itemview.setTranslationX(itemview.getX() + 400);
        itemview.setAlpha(0.f);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(itemview, "translationX", itemview.getX(), +400,0);
        ObjectAnimator animatorx = ObjectAnimator.ofFloat(itemview, "alpha", 1.f);
        ObjectAnimator.ofFloat(itemview, "alpha", 0.f).start();
        animatorY.setStartDelay(isNotFirst ? 150 : (i * 150));
        animatorY.setDuration((isNotFirst ? 2 : 1) * 150);
        set.playTogether(animatorY, animatorx);
        set.start();

    }



}
