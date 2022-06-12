package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationslist =new ArrayList<>();

    private  int playerturn=1;

    private  int totalselectedboxes=1;

    private LinearLayout playeronelayout,playertwolayout;

    private TextView playeronename,playertwoname;

    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    private int [] boxPositions={0,0,0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playeronename=findViewById(R.id.player1name);
        playertwoname=findViewById(R.id.player2name);

        playeronelayout=findViewById(R.id.player1layout);
        playertwolayout=findViewById(R.id.player2layout);

          image1=findViewById(R.id.image1);
          image2=findViewById(R.id.image2);
          image3=findViewById(R.id.image3);
          image4=findViewById(R.id.image4);
          image5=findViewById(R.id.image5);
          image6=findViewById(R.id.image6);
          image7=findViewById(R.id.image7);
          image8=findViewById(R.id.image8);
          image9=findViewById(R.id.image9);

        combinationslist.add(new int[]{0,1,2});
        combinationslist.add(new int[]{3,4,5});
        combinationslist.add(new int[]{6,7,8});
        combinationslist.add(new int[]{0,3,6});
        combinationslist.add(new int[]{1,4,7});
        combinationslist.add(new int[]{2,5,8});
        combinationslist.add(new int[]{2,4,6});
        combinationslist.add(new int[]{0,4,8});


        final  String getplayeronename=getIntent().getStringExtra("player one");
        final  String getplayertwoname=getIntent().getStringExtra("player two");

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(0)){

                    performAction((ImageView) view,0);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(1)){

                    performAction((ImageView) view,1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(2)){

                    performAction((ImageView) view,2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(3)){

                    performAction((ImageView) view,3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(4)){

                    performAction((ImageView) view,4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(5)){

                    performAction((ImageView) view,5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(6)){

                    performAction((ImageView) view,6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(7)){

                    performAction((ImageView) view,7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isboxselectable(8)){
                    performAction((ImageView) view,8);
                }
            }
        });

        playeronename.setText(getplayeronename);
        playertwoname.setText(getplayertwoname);



    }

    private void performAction(ImageView imageView,int selectedboxposition){
        boxPositions[selectedboxposition]=playerturn;
        if(playerturn==1)
        {
            imageView.setImageResource(R.drawable.cross);
            if(checkplayerwin()){

                windialog windialog=new windialog(MainActivity.this,playeronename.getText().toString()+" Person having cross has won the match",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else if(totalselectedboxes==9){

                windialog windialog=new windialog(MainActivity.this,"It is a draw",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else{

                changeplayerturn(2);
                totalselectedboxes++;
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.circle);
            if(checkplayerwin()){

                windialog windialog=new windialog(MainActivity.this,playertwoname.getText().toString()+"Person having zero has won the match",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else if(selectedboxposition==9)
            {
                windialog windialog=new windialog(MainActivity.this,"It is a draw",MainActivity.this);
                windialog.setCancelable(false);
                windialog.show();
            }
            else
            {
                changeplayerturn(1);

                totalselectedboxes++;
            }
        }
    }
    private void changeplayerturn(int currentplayerturn){
        playerturn=currentplayerturn;
        if(playerturn==1)
        {
            playeronelayout.setBackgroundResource(R.drawable.roundbackborder);
            playertwolayout.setBackgroundResource(R.drawable.roundbackborder);
        }
        else{
            playeronelayout.setBackgroundResource(R.drawable.roundbackborder);
            playertwolayout.setBackgroundResource(R.drawable.roundbackborder);
        }
    }
    private boolean checkplayerwin()
    {
        boolean response=false;
         for(int i=0;i<combinationslist.size();i++)
         {
             final int[] combination=combinationslist.get(i);

             if(boxPositions[combination[0]]==playerturn && boxPositions[combination[1]]==playerturn && boxPositions[combination[2]]==playerturn)
             {
                    response=true;
             }
         }
         return response;
    }
    private boolean isboxselectable(int boxposition){
        boolean response =false;
        if(boxPositions[boxposition]==0){
            response=true;
        }
        return response;
    }
    public void restartmatch()
    {
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0};

        playerturn=1;

        totalselectedboxes=1;

        image1.setImageResource(R.drawable.gameback);
        image2.setImageResource(R.drawable.gameback);
        image3.setImageResource(R.drawable.gameback);
        image4.setImageResource(R.drawable.gameback);
        image5.setImageResource(R.drawable.gameback);
        image6.setImageResource(R.drawable.gameback);
        image7.setImageResource(R.drawable.gameback);
        image8.setImageResource(R.drawable.gameback);
        image9.setImageResource(R.drawable.gameback);
    }
}