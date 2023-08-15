package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;



public class MainActivity2 extends AppCompatActivity {


    private static Vibrator vibrator;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button newgamebtn = findViewById(R.id.newgamebtn);
        Button signout = findViewById(R.id.signout);
        Button lederbrdbtn = findViewById(R.id.leaderboadbtn);
        Button quitbtn = findViewById(R.id.quitbtn);
        Button b = findViewById(R.id.b);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);
// Java





        newgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDiff();




            }
        });

        lederbrdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VibratorUtils.vibrate(37);
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);

            }
        });

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity2.this.finish();

                // on below line we are exiting our activity
                System.exit(0);
            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VibratorUtils.vibrate(37);
                Intent i = new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(i);
            }
        });
    }
    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
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