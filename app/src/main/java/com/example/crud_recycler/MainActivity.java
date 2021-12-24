package com.example.crud_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Employee> data;
    Button add,upd,dlt,view;
    TextView name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.myrec);
        data=new ArrayList<>();
        add=findViewById(R.id.insert);
        view=findViewById(R.id.all);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db=new DbHelper(MainActivity.this);
                name=findViewById(R.id.name);
                age=findViewById(R.id.age);
                if(name.getText()==null||age.getText()==null){
                    Toast.makeText(MainActivity.this, "Enter Data in Fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean res=db.insert(name.getText().toString(),Integer.parseInt(String.valueOf(age.getText())));
                    if(res){
                        Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db=new DbHelper(MainActivity.this);
                data=db.allData();
                setAdapter();

            }
        });




    }

    private void setAdapter(){
        EmpAdapter adapter=new EmpAdapter(data,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


}