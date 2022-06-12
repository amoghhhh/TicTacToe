package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpalyers);



        final EditText playerone=findViewById(R.id.player1name);
        final EditText playertwo=findViewById(R.id.player2name);
        final EditText startgame=findViewById(R.id.startgame);


        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String getplaye1rname=playerone.getText().toString();
                final String getplaye2rname=playertwo.getText().toString();

                if(getplaye1rname.isEmpty() || getplaye2rname.isEmpty()){
                    Toast.makeText(Players.this,"please enter player names", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent=new Intent(Players.this,MainActivity.class);
                    intent.putExtra("player one",getplaye1rname);
                    intent.putExtra("player two",getplaye2rname);
                    startActivity(intent);
                }
            }
        });

    }
}