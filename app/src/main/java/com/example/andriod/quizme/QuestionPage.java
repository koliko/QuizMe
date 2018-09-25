package com.example.andriod.quizme;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionPage extends AppCompatActivity {

    //======================================================//
    //  This part declares the views from the XML for use   //
    //=====================================================//

    //  Answer for Q {1,3,6,8,9,10}
    RadioButton quesOneAn1;
    RadioButton quesThreeAn4;
    RadioButton quesSixAn3;
    RadioButton quesEightAn3;
    RadioButton quesNineAn1;
    RadioButton quesTenAn1;

    Boolean answer1;
    String answer4;
    Boolean answer6;
    Boolean answer8;
    Boolean answer9;
    Boolean answer10;
    Boolean answer3;
    Boolean answer5;
    Boolean answer7;
    Boolean answer2_one;
    Boolean answer2_two;
    Boolean answer2_three;
    Boolean answer2_four;


    //  Answer for Q {2,5,7}
    CheckBox quesTwoAn1;
    CheckBox quesTwoAn2;
    CheckBox quesTwoAn3;
    CheckBox quesTwoAn4;
    CheckBox quesFiveAn2;
    CheckBox quesSevenAn2;

    //  Answer for Q {4}
    EditText quesFourAns;
    EditText bonusQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_question_page );


        TextView firstName;
        String firstString;

        firstName = findViewById( R.id.name );

        Intent welcomName = getIntent();
        firstString = welcomName.getStringExtra( "nameKey" );

        firstName.setText( "Welcome " + firstString );

    }
    //=============================================================//
    // The main code for checking of the quiz                     //
    //===========================================================//

    // Calling the onCreate method from the XML

    public void submitQuiz(View view) {

        //==================================================//
        // Variables for the quiz score                    //
        //================================================//

        int ansScoreOne;
        int ansScoreTwo;
        int ansScoreThree;
        int ansScoreFour;
        int ansScoreFive;
        int ansScoreSix;
        int ansScoreSeven;
        int ansScoreEight;
        int ansScoreNine;
        int ansScoreTen;
        int totalScore;
        int bounsSccore;
        String displayScore;

        // Question one

        quesOneAn1 = findViewById( R.id.qus1An1 );
        answer1 = quesOneAn1.isChecked();

        if (answer1) {
            ansScoreOne = 1;
        } else {
            ansScoreOne = 0;
        }

        //Question two
        quesTwoAn1 = findViewById( R.id.qus2An1 );
        quesTwoAn2 = findViewById( R.id.qus2An2 );
        quesTwoAn3 = findViewById( R.id.qus2An3 );
        quesTwoAn4 = findViewById( R.id.qus2An4 );
        answer2_one = quesTwoAn1.isChecked();
        answer2_two = quesTwoAn2.isChecked();
        answer2_three = quesTwoAn3.isChecked();
        answer2_four = quesTwoAn4.isChecked();

        if (answer2_one && answer2_four && answer2_three && answer2_two) {
            ansScoreTwo = 1;
        } else {
            ansScoreTwo = 0;
        }

        //Question three
        quesThreeAn4 = findViewById( R.id.qus3An4 );
        answer3 = quesThreeAn4.isChecked();

        if (answer3) {
            ansScoreThree = 1;
        } else {
            ansScoreThree = 0;
        }

        //Question four
        quesFourAns = findViewById( R.id.qus4An1 );
        answer4 = quesFourAns.getText().toString().toLowerCase();

        if (answer4 == "Many" || answer4 == "many") {
            ansScoreFour = 1;
        } else {
            ansScoreFour = 0;
        }

        //Question Five
        quesFiveAn2 = findViewById( R.id.qus5An2 );
        answer5 = quesFiveAn2.isChecked();

        if (answer5) {
            ansScoreFive = 1;
        } else {
            ansScoreFive = 0;
        }

        //Question Six

        quesSixAn3 = findViewById( R.id.qus6An3 );
        answer6 = quesSixAn3.isChecked();

        if (answer6) {
            ansScoreSix = 1;
        } else {
            ansScoreSix = 0;
        }

        //Question Seven
        quesSevenAn2 = findViewById( R.id.qus7An2 );
        answer7 = quesSevenAn2.isChecked();

        if (answer7) {
            ansScoreSeven = 1;
        } else {
            ansScoreSeven = 0;
        }

        //Question Eight
        quesEightAn3 = findViewById( R.id.qus8An3 );
        answer8 = quesEightAn3.isChecked();

        if (answer8) {
            ansScoreEight = 1;
        } else {
            ansScoreEight = 0;
        }

        //Question Nine
        quesNineAn1 = findViewById( R.id.qus9An1 );
        answer9 = quesNineAn1.isChecked();

        if (answer9) {
            ansScoreNine = 1;
        } else {
            ansScoreNine = 0;
        }

        //Question Ten
        quesTenAn1 = findViewById( R.id.qus10An1 );
        answer10 = quesTenAn1.isChecked();

        if (answer10) {
            ansScoreTen = 1;
        } else {
            ansScoreTen = 0;
        }

//        bouns question

        bonusQ = findViewById( R.id.bonusid );

        if (bonusQ.getText().toString() == "Stev Job" || bonusQ.getText().toString() == "stev job") {
            bounsSccore = 3;
        } else {
            bounsSccore = 0;
        }


        //===================================================//
        // taking the final score of the quiz               //
        //=================================================//

        totalScore = ansScoreOne + ansScoreTwo + ansScoreThree + ansScoreFour + ansScoreFive + ansScoreSix
                + ansScoreSeven + ansScoreEight + ansScoreNine + ansScoreTen + bounsSccore;

        if (totalScore == 10) {
            displayScore = "TOTAL SCORE : 10/10";

        } else if (totalScore == 13) {
            displayScore = " TOTAL SCORE : 10/10 + BOUNS = 103%";
        } else {
            displayScore = "TOTAL SCORE : " + totalScore + "/ 10";
        }

        Toast.makeText( QuestionPage.this, displayScore, Toast.LENGTH_SHORT ).show();

        Intent intent = new Intent( QuestionPage.this, ScorePage.class );
        intent.putExtra( "key", displayScore );
        startActivity( intent );

    }
}
