package com.example.crud_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.MyViewHolder> {
    @NonNull
    private ArrayList<Employee> data;
    private Context context;
    public EmpAdapter(ArrayList<Employee> data, Context context){

        this.data=data;
        this.context=context;
    }




    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name=data.get(position).getName();
        int age_emp=data.get(position).getAge();

        holder.emp_name.setText(name);
        holder.age.setText(Integer.toString(age_emp));

        holder.upt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db=new DbHelper(context);
                db.update(name,age_emp,1);
                }
        });

        holder.dlt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db=new DbHelper(context);
                db.delete(name,age_emp,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView emp_name,age;
        private Button upt_btn,dlt_btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            emp_name=itemView.findViewById(R.id.emp_name);
            age=itemView.findViewById(R.id.emp_age);
            upt_btn=itemView.findViewById(R.id.update);
            dlt_btn=itemView.findViewById(R.id.dlt);
        }
    }

}
