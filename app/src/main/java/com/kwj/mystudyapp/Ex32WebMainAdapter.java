package com.kwj.mystudyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ex32WebMainAdapter extends RecyclerView.Adapter<Ex32WebMainAdapter.ViewHolder> {

    public ArrayList<Ex32ItemData> itemData;
    public Ex32WebMainAdapter(ArrayList<Ex32ItemData> itemData) {
        this.itemData = itemData;
    }

    public interface MyRecyclerViewClickListener{
        void onNameClicked(int position);
        void onHpClicked(int position);
        void onItemLongClicked(int position);

    }


    private MyRecyclerViewClickListener mListener;

    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        this.mListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_ex32_web_main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Ex32ItemData item = itemData.get(position);
        holder.tvId.setText(item.getId());
        holder.tvName.setText(item.getName());
        holder.tvHp.setText(item.getHp());

        if (mListener != null) {
            final int pos = position;




            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onNameClicked(pos);
                }
            });
            holder.tvId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onHpClicked(pos);
                }
            });

            holder.tvHp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onHpClicked(pos);
                }
            });



            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.onItemLongClicked(holder.getAdapterPosition());
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvHp,tvId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvHp = itemView.findViewById(R.id.tvHp);

        }
    }

    //리스트 삭제 이벤트
    public void remove(int position){
        try {
            itemData.remove(position);
            notifyDataSetChanged();
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}