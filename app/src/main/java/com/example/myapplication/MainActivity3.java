package com.example.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String>dataSource;
    ArrayList<Integer> color;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;
    String  firstcard="#27FF80AB";
    int firstcardInt = Color.parseColor(firstcard);
    String  secondcard="#2CB388FF";
    int secondcardInt = Color.parseColor(secondcard);
    String  thirdcard="#36FFFF8D";
    int thirdcardInt = Color.parseColor(thirdcard);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            startActivity(intent);

        });


        rv=findViewById(R.id.horizontalRv);
        dataSource =new ArrayList<>();
        dataSource.add("cricket-projectv2.fig");
        dataSource.add("briefing from client.pdf");
        dataSource.add("mountain asset.png");
        color =new ArrayList<>();
        color.add(firstcardInt);
        color.add(secondcardInt);
        color.add(thirdcardInt);
       


        linearLayoutManager= new LinearLayoutManager(MainActivity3.this,LinearLayoutManager.HORIZONTAL,false);
        myRvAdapter= new MyRvAdapter(dataSource,color);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);
    }
    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>{
        ArrayList<String> data;
        ArrayList<Integer> color;
        public MyRvAdapter(ArrayList<String> data, ArrayList<Integer> color) {
            this.data=data;
            this.color=color;

        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(MainActivity3.this).inflate(R.layout.rv_item,parent,false);

            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.parent.setBackgroundColor((Integer) color.get(position));
            holder.file.setText(data.get(position));
        }
        @Override
        public int getItemCount(){ return data.size();}

        class MyHolder extends RecyclerView.ViewHolder{
            TextView file;
           RelativeLayout parent;

            public MyHolder (@NonNull View itemView){

                super(itemView);
                file=itemView.findViewById(R.id.textView22);
                parent= itemView.findViewById(R.id.parent);
            }

        }
    }
}