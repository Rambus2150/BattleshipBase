package edu.utep.cs.cs4330.battleship;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private Board  playerBoard = new Board(10);
    private BoardView playerBoardView;
    Fleet playerFleet;
    RadioGroup rgroup;
    RadioButton shipselect;
    RadioGroup sgroup;
    RadioButton stratSelect;
    Boolean vertical = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        defineButtons();
        playerBoardView = (BoardView) findViewById(R.id.boardView2);
        playerBoardView.setBoard(playerBoard);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        rgroup=(RadioGroup) findViewById(R.id.rgroup);
        sgroup=(RadioGroup) findViewById(R.id.sgroup);
        playerBoardView.addBoardTouchListener(new BoardView.BoardTouchListener() {
            @Override
            public void onTouch(int x, int y) {

            }

        });

    }
    private View.OnClickListener buttonClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.randomButton:
                    playerFleet=new Fleet(playerBoard);
                    break;
                case R.id.clearButton:
                    playerFleet=new Fleet();
                    break;
                case R.id.startButton:
                    break;
                case R.id.orientation:
                    vertical =(!vertical);
                    break;
            }
        }
    };
    public void  defineButtons(){
        findViewById(R.id.randomButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.clearButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.startButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.orientation).setOnClickListener(buttonClickListener);


    }
    public void shipSelect(View v){
        int radioButtonId= rgroup.getCheckedRadioButtonId();
        shipselect=(RadioButton) findViewById(radioButtonId);
        Toast.makeText(getBaseContext(),shipselect.getText(),Toast.LENGTH_LONG).show();
    }
    public void strategySelect(View V){
        int radioButtonId= sgroup.getCheckedRadioButtonId();
        stratSelect=(RadioButton) findViewById(radioButtonId);
        Toast.makeText(getBaseContext(),stratSelect.getText(),Toast.LENGTH_LONG).show();
    }

}