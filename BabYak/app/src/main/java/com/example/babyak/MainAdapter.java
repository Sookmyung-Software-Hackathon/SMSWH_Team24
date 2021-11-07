package com.example.babyak;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    private Context mContext;
    private ArrayList<MainData> arrayList;

    public MainAdapter(Context mContext, ArrayList<MainData> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);




        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_title.setText(arrayList.get(position).getTv_title());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        holder.tv_date.setText(arrayList.get(position).getTv_date());
        holder.tv_place.setText(arrayList.get(position).getTv_place());
        holder.tv_people.setText(arrayList.get(position).getTv_people());
        holder.tv_writer.setText(arrayList.get(position).getTv_writer());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),PostActivity.class);
                mContext.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        protected ImageView iv_profile;
        protected TextView tv_title;
        protected TextView  tv_content;
        protected TextView  tv_date;
        protected TextView  tv_place;
        protected TextView tv_people;
        protected TextView  tv_writer;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.list_iv_profile);
            this.tv_title = (TextView) itemView.findViewById(R.id.list_item_title);
            this.tv_content = (TextView) itemView.findViewById(R.id.list_item_content);
            this.tv_date = (TextView) itemView.findViewById(R.id.list_item_date);
            this.tv_place = (TextView) itemView.findViewById(R.id.list_item_place);
            this.tv_people = (TextView) itemView.findViewById(R.id.list_item_people);
            this.tv_writer = (TextView) itemView.findViewById(R.id.list_item_writer);
        }


    }
}
