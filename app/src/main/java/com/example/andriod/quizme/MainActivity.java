package com.example.andriod.quizme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    Button startQuiz;
    TextView quizInstruction;
    String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


//        finding the views by their IDs
        firstName = findViewById( R.id.firstName );
        startQuiz = findViewById( R.id.startQuiz );

        startQuiz.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setting rules for the firstname filed

                if ((!firstName.getText().toString().isEmpty())) {
//                    if the first name is provided go to the question page

                    Intent intent = new Intent( MainActivity.this, QuestionPage.class );
                    myString = firstName.getText().toString();
                    intent.putExtra( "nameKey", myString );
                    startActivity( intent );

                } else {
                    Toast.makeText( MainActivity.this, "Please provide a FIRST NAME",
                            Toast.LENGTH_LONG ).show();
                }
            }
        } );
    }
}
