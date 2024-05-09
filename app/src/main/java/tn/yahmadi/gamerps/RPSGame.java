package tn.yahmadi.gamerps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.SecureRandom;

public class RPSGame extends AppCompatActivity {

    private TextView TextViewPlayer1 , TextViewPlayer2, TextViewResault ;
    private ImageView ImageViewPlayer1 , ImageViewPlayer2 ;
    private Button play ;

    private int player1 , player2;
    private int ResPl1 , ResPl2 ;
    private int essai = 0 ;

    private final int  Rock = 1,Paper = 2,Scissors = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rpsgame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextViewPlayer1 =  findViewById(R.id.textViewPl1);
        TextViewPlayer2 =  findViewById(R.id.textViewPl2);
        TextViewResault =  findViewById(R.id.textViewResult);

        ImageViewPlayer1 =  findViewById(R.id.imageView1);
        ImageViewPlayer2 =  findViewById(R.id.imageView2);

        play =  findViewById(R.id.play);

        TextViewPlayer1.setText(getIntent().getStringExtra("player1"));
        TextViewPlayer2.setText(getIntent().getStringExtra("player2"));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(essai<3){
                    player1 = new SecureRandom().nextInt(3)+1;
                    switch (player1){
                        case 1 :  ImageViewPlayer1.setImageResource(R.drawable.rock); break;
                        case 2 :  ImageViewPlayer1.setImageResource(R.drawable.paper);break;
                        case 3 :  ImageViewPlayer1.setImageResource(R.drawable.scissors);break;
                    }
                    player2 = new SecureRandom().nextInt(3)+1;
                    switch (player2){
                        case 1 :  ImageViewPlayer2.setImageResource(R.drawable.rock); break;
                        case 2 :  ImageViewPlayer2.setImageResource(R.drawable.paper);break;
                        case 3 :  ImageViewPlayer2.setImageResource(R.drawable.scissors);break;
                    }
                    Verify(player1,player2);
                    essai++;
                }
                if(essai>=3){
                    if(ResPl1==ResPl2)
                        TextViewResault.setText(R.string.Resualt1);
                    if (ResPl1>ResPl2)
                        TextViewResault.setText(TextViewPlayer1.getText().toString()+" "+getString( R.string.Resualt2));
                    if (ResPl1<ResPl2)
                        TextViewResault.setText(TextViewPlayer2.getText().toString()+" "+getString( R.string.Resualt2));
                }
            }
        });
    }

    private void Verify(int player1 , int player2){
        if(player1==player2)
            ResPl1+=0;
         else if ((player1 == Rock && player2 == Scissors) ||
                  (player1 == Paper && player2 == Rock) ||
                  (player1 == Scissors && player2 == Paper))
            ResPl1++;
         else
            ResPl2++;
    }
}