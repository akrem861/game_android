package tn.yahmadi.gamerps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

   private EditText editTextPlayer1 , editTextPlayer2 ;
   private Button valider ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       editTextPlayer1 =  findViewById(R.id.editTextPlayer1);
       editTextPlayer2 =  findViewById(R.id.editTextPlayer2);
       valider =  findViewById(R.id.valider);

       Intent intent = new Intent(MainActivity.this,RPSGame.class);

       valider.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               intent.putExtra("player1",editTextPlayer1.getText().toString());
               intent.putExtra("player2",editTextPlayer2.getText().toString());
               startActivity(intent);
           }
       });



    }
}