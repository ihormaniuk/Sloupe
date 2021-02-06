package com.groot.sloupe.ClassSloupe;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.Adapter<Holder.adapter> {
    @NonNull
    @Override
    public adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class adapter extends RecyclerView.ViewHolder{

        public adapter(@NonNull View itemView) {
            super(itemView);
        }
    }
}
