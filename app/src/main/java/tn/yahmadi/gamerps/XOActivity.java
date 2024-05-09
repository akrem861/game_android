package tn.yahmadi.gamerps;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class XOActivity extends AppCompatActivity {

    private TextView textViewPlay1,textViewPlay2, textViewRes;
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private boolean xo = true;
    private int moveCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xoactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        textViewPlay1 = findViewById(R.id.textViewPlay1);
        textViewPlay2 = findViewById(R.id.textViewPlay2);
        textViewRes = findViewById(R.id.textViewRes);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView1.setImageResource(R.drawable.x);
                    imageView1.setClickable(false);
                    board[0][0]='x';
                }
                else{
                    imageView1.setImageResource(R.drawable.o);
                    imageView1.setClickable(false);
                    board[0][0]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView2.setImageResource(R.drawable.x);
                    imageView2.setClickable(false);
                    board[0][1]='x';
                }
                else{
                    imageView2.setImageResource(R.drawable.o);
                    imageView2.setClickable(false);
                    board[0][1]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView3.setImageResource(R.drawable.x);
                    imageView3.setClickable(false);
                    board[0][2]='x';
                }
                else{
                    imageView3.setImageResource(R.drawable.o);
                    imageView3.setClickable(false);
                    board[0][2]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView4.setImageResource(R.drawable.x);
                    imageView4.setClickable(false);
                    board[1][0]='x';
                }
                else{
                    imageView4.setImageResource(R.drawable.o);
                    imageView4.setClickable(false);
                    board[1][0]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView5.setImageResource(R.drawable.x);
                    imageView5.setClickable(false);
                    board[1][1]='x';
                }
                else{
                    imageView5.setImageResource(R.drawable.o);
                    imageView5.setClickable(false);
                    board[1][1]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView6.setImageResource(R.drawable.x);
                    imageView6.setClickable(false);
                    board[1][2]='x';
                }
                else{
                    imageView6.setImageResource(R.drawable.o);
                    imageView6.setClickable(false);
                    board[1][2]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(xo){
                    imageView7.setImageResource(R.drawable.x);
                    imageView7.setClickable(false);
                    board[2][0]='x';
                }
                else{
                    imageView7.setImageResource(R.drawable.o);
                    imageView7.setClickable(false);
                    board[2][0]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView8.setImageResource(R.drawable.x);
                    imageView8.setClickable(false);
                    board[2][1]='x';
                }
                else{
                    imageView8.setImageResource(R.drawable.o);
                    imageView8.setClickable(false);
                    board[2][1]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xo){
                    imageView9.setImageResource(R.drawable.x);
                    imageView9.setClickable(false);
                    board[2][2]='x';
                }
                else{
                    imageView9.setImageResource(R.drawable.o);
                    imageView9.setClickable(false);
                    board[2][2]='o';
                }

                xo=!xo;
                moveCount++;
                valid();
            }
        });





    }

    private boolean checkForWin(char playerMark) {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == playerMark && board[i][1] == playerMark && board[i][2] == playerMark) {
                return true; // Win in row i
            }
            // Check columns
            if (board[0][i] == playerMark && board[1][i] == playerMark && board[2][i] == playerMark) {
                return true; // Win in column i
            }
        }
        // Check diagonals for a win
        if (board[0][0] == playerMark && board[1][1] == playerMark && board[2][2] == playerMark) {
            return true; // Win in top-left to bottom-right diagonal
        }
        if (board[0][2] == playerMark && board[1][1] == playerMark && board[2][0] == playerMark) {
            return true; // Win in top-right to bottom-left diagonal
        }
        return false; // No win detected
    }


    private void disableAllImageViews() {
        imageView1.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        imageView4.setClickable(false);
        imageView5.setClickable(false);
        imageView6.setClickable(false);
        imageView7.setClickable(false);
        imageView8.setClickable(false);
        imageView9.setClickable(false);
    }

    private void valid(){
        if (moveCount >= 3) {
            // Check for win condition after 3 or more moves
            if (checkForWin('x')) {
                textViewRes.setText("Player 1 (X) wins!");
                disableAllImageViews();
                return;
            } else if (checkForWin('o')) {
                textViewRes.setText("Player 2 (O) wins!");
                disableAllImageViews();
                return;
            }
        }
    }




}

