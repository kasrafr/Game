package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class connectThreeActivity extends AppCompatActivity {
public  static   final int YELLOW_COD=0;
    public  static   final int RED_COD=1;
    public  static   final int NOT_PLAYED=2;
    private static final int NO_WINNER =-1 ;
    int gamestate[]={NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,
          NOT_PLAYED,NOT_PLAYED,NOT_PLAYED,
          NOT_PLAYED,NOT_PLAYED,NOT_PLAYED};
 int activeplayer=RED_COD;
 int winner=NO_WINNER;
 int[][] winingPosition ={{0,1,2},{3,4,5},{6,7,8},
                       {0,3,6},{1,4,7},{2,5,8},
                       {0,4,8},{2,4,6},
 };
 RelativeLayout msgLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_ground);
        msgLayout=findViewById(R.id.msg_layout);
        msgLayout.setVisibility(View.GONE);
    }
    public  void dropIn(View view) {
        int tag=Integer.parseInt ((String) view.getTag());
        if(winner !=NO_WINNER || gamestate[NOT_PLAYED]!=NOT_PLAYED)
        {return;}
        ImageView img= (ImageView) view;

        if(activeplayer==RED_COD)
        {
            activeplayer=YELLOW_COD;
            img.setImageResource(R.drawable. red);
            gamestate[tag]=RED_COD;
        }
        else if(activeplayer==YELLOW_COD)
        {
            activeplayer=RED_COD;
            img.setImageResource(R.drawable.yellow);
            gamestate[tag]=YELLOW_COD;
        }
         winner= checkwinner();
        //check winner
        winner_msg();
    }
    private void winner_msg() {
        winner=checkwinner();
        if(winner !=NO_WINNER||filled())
        {
            int color=Color.GREEN;
            String msg="";
            if(winner==NO_WINNER)
            {
                msg="No Winner";
            }
            else if(winner==RED_COD)
            {
                color=Color.RED;
                msg="Red Win";
            }
            else if(winner==YELLOW_COD)
            {
                color=Color.YELLOW;
                msg="yellow win";
            }
            msgLayout.setBackgroundColor(color);
            ((TextView) msgLayout.findViewById(R.id.winner_msg)).setText(msg);
            msgLayout.setVisibility(View.VISIBLE);
        }
    }
    //no winer: -1
    //red: red_code
    //yellow: yellow_code
    public int checkwinner() {
        for(int[] position:winingPosition)
        {
         if(gamestate[position[0]]==gamestate[position[1]]&&
                 gamestate[position[1]]==gamestate[position[2]]&&
                 gamestate[position[0]]!=NOT_PLAYED)
         return gamestate[position[0]];

        }
return  NO_WINNER;
    }
    public boolean filled(){
      for(int i=0;i<gamestate.length;i++)
      {
          if(gamestate[i]==NOT_PLAYED)
               return false;
      }
    return  true;

  }
    public void reset(View v){
        //active player
        activeplayer=RED_COD;
        //winner
        winner=NO_WINNER;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=NOT_PLAYED;
        }
        //play ground
        LinearLayout pglayout=findViewById(R.id.pg_layout);
        for(int i=0;i<pglayout.getChildCount();i++) {
            LinearLayout row= (pglayout.getChildAt(i) instanceof LinearLayout)? (LinearLayout) pglayout.getChildAt(i) : null;
            if (row==null) return;
            for(int j=0;j<row.getChildCount();j++)
            {
                ImageView iv= (row.getChildAt(j) instanceof ImageView)? (ImageView) row.getChildAt(j) : null;
                if (iv==null) return;
                iv.setImageResource(0);
            }
        }
        msgLayout.setVisibility(View.GONE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem resetitem=menu.add("Reset");
        resetitem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        resetitem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                reset(null);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
