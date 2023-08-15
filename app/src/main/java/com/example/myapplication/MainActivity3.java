package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper myDB;
    ArrayList<String> id,name,score,level;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerview);
        myDB=new DBHelper(MainActivity3.this);
        id=new ArrayList<>();
        name=new ArrayList<>();
        score=new ArrayList<>();
        level=new ArrayList<>();
        storeDataInArrays();
        customAdapter=new CustomAdapter(MainActivity3.this,id,name,score,level);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));

    }
    void storeDataInArrays(){
        Cursor cursor=myDB.readallData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                score.add(cursor.getString(2));
                level.add(cursor.getString(3));

            }
        }
    }
}