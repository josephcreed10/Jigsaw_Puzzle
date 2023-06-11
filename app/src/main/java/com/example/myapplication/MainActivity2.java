package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button newgamebtn = findViewById(R.id.newgamebtn);
        Button loadgamebtn = findViewById(R.id.loadgame);
        Button lederbrdbtn = findViewById(R.id.leaderboadbtn);
        Button quitbtn = findViewById(R.id.quitbtn);


        newgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDiff();




            }
        });

        loadgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        lederbrdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void setDiff(){
        Dialog dialog=new Dialog(MainActivity2.this,R.style.customdlg);
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View custom_dialog=layoutInflater.inflate(R.layout.cstm_diff,null);
        dialog.setContentView(custom_dialog);
        dialog.setTitle("Select Difficulty Level:");
        dialog.show();
        Button btnEasy=custom_dialog.findViewById(R.id.easy);
        Button btnMedium=custom_dialog.findViewById(R.id.medium);
        Button btnHard=custom_dialog.findViewById(R.id.hard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int difficulty=0;
                Intent intent= new Intent(MainActivity2.this,PuzzlegridActivity.class);
                intent.putExtra("difficulty",difficulty );
                startActivity(intent);
            }
        });


        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int difficulty=1;
                Intent intent= new Intent(MainActivity2.this,PuzzlegridActivity.class);
                intent.putExtra("difficulty",difficulty );
                startActivity(intent);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int difficulty=2;
                Intent intent= new Intent(MainActivity2.this,PuzzlegridActivity.class);
                intent.putExtra("difficulty",difficulty );
                startActivity(intent);
            }
        });


    }
}