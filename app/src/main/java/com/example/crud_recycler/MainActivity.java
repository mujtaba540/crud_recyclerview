package com.example.crud_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Employee> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.myrec);
        data=new ArrayList<>();

        DbHelper db=new DbHelper(this);

        setEmployeeInfo();
        setAdapter();
    }

    private void setAdapter(){
        EmpAdapter adapter=new EmpAdapter(data);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setEmployeeInfo(){
        data.add(new Employee("mujtbata","lahore","123"));
        data.add(new Employee("mujtbata","lahore","123"));
    }

}