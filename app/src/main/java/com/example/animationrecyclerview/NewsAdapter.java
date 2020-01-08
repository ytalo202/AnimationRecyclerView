package com.example.animationrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context mContext;
    List<NewsItem> mData;
    boolean isDark = false;

    public NewsAdapter(Context mContext, List<NewsItem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
    }

    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        // animation
        holder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_content.setText(mData.get(position).getContent());
        holder.tv_date.setText(mData.get(position).getDate());
        holder.img_user.setImageResource(mData.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_content, tv_date;
        ImageView img_user;
        RelativeLayout container;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);
            container = itemView.findViewById(R.id.action_container);
            if (isDark){
                setDarkTheme();
            }
        }

        private void setDarkTheme() {
            container.setBackgroundResource(R.drawable.card_bg_dark);
        }
    }
}
