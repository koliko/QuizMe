package com.example.andriod.quizme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ScorePage extends AppCompatActivity {

    TextView toms;
    TextView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_score_page );

        toms = findViewById( R.id.extras );

        exit = findViewById( R.id.exit );

        Intent intent = getIntent();

        String talk = intent.getStringExtra( "key" );

        toms.setText( talk );

        //===================================================//
        // This part is an adapter that put all question in //
        // in a list format.                               //
        //================================================//

        ListView qusList = findViewById( R.id.qusReview );
        final String[] qusView = getResources().getStringArray( R.array.questionReview );
        ArrayAdapter<String> qusReview = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, qusView );
        qusList.setAdapter( qusReview );

        qusList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv = (TextView) view;
                String string = (String) tv.getText();

                Toast.makeText( ScorePage.this, string, Toast.LENGTH_SHORT ).show();
            }
        } );

        exit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent( ScorePage.this, MainActivity.class );
                startActivity( exit );
            }
        } );

    }

}
