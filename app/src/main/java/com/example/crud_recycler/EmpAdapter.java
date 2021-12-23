package com.example.crud_recycler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView emp_name,emp_loc,emp_des;
        private Button upt_btn,dlt_btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            emp_name=itemView.findViewById(R.id.emp_name);
            emp_loc=itemView.findViewById(R.id.emp_loc);
            emp_des=itemView.findViewById(R.id.emp_des);
            upt_btn=itemView.findViewById(R.id.update);
            dlt_btn=itemView.findViewById(R.id.dlt);
        }
    }
}
