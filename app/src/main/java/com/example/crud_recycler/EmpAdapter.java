package com.example.crud_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.MyViewHolder> {
    @NonNull
    private ArrayList<Employee> data;
    public EmpAdapter(ArrayList<Employee> data){
        this.data=data;
    }




    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name=data.get(position).getName();
        holder.emp_name.setText(name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
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
