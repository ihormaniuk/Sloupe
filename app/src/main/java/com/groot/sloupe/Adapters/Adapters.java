package com.groot.sloupe.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.groot.sloupe.R;

public class Adapters extends RecyclerView.Adapter<Adapters.AdaptersParse> {

    @NonNull
    @Override
    public AdaptersParse onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        return new AdaptersParse(view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptersParse holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class AdaptersParse extends RecyclerView.ViewHolder {

        private TextView textView;

        public AdaptersParse(@NonNull View itemView) {
            super(itemView);
//            textView.findViewById(R.id.textViewHolder);
        }
    }

}
