package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mStory;
    Button mFirstChoice;
    Button mSecondChoice;
    int yourAnswer=0;








    private storyGuideLine[] mBluePrint= new storyGuideLine[]{
            new storyGuideLine(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new storyGuideLine(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new storyGuideLine(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new storyGuideLine(R.string.T4_End,R.string.myNull,R.string.myNull),
            new storyGuideLine(R.string.T5_End,R.string.myNull,R.string.myNull),
            new storyGuideLine(R.string.T6_End,R.string.myNull,R.string.myNull)



    };


    // TODO: Steps 4 & 8 - Declare member variables here:


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            
            yourAnswer=savedInstanceState.getInt("YourAnswer");


        }
        else{

            yourAnswer=0;
        }



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStory = (TextView) findViewById(R.id.storyTextView);
        mFirstChoice=(Button)findViewById(R.id.buttonTop);
        mSecondChoice=(Button) findViewById(R.id.buttonBottom);
        checkAnswer();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mFirstChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Log.d("choice1","you picked the first choice");


                if (yourAnswer==0){

                    yourAnswer=1;
                    checkAnswer();
                    yourAnswer=3;

                }
                else if (yourAnswer==3){

                    yourAnswer=6;
                    checkAnswer();


                }
                else if (yourAnswer==4){
                    yourAnswer=3;
                    checkAnswer();

                }


            }
        });
// TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mSecondChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Log.d("choice2","you picked the second choice");

                if (yourAnswer==0){

                    yourAnswer=2;
                    checkAnswer();
                    yourAnswer=4;


                }
                else if (yourAnswer==4){

                    checkAnswer();


                }
                else if (yourAnswer==3){

                    yourAnswer=5;
                    checkAnswer();


                }


            }
        });





    }




    public void checkAnswer(){
        int mQuestion;
        int mAnswer1;
        int mAnswer2;



        if (yourAnswer==1 ){

            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_1,Toast.LENGTH_LONG);
            mytoast.show();

            mQuestion = mBluePrint[2].getStory();
            mStory.setText(mQuestion);

            mAnswer1=mBluePrint[2].getAns1();
            mFirstChoice.setText(mAnswer1);

            mAnswer2=mBluePrint[2].getAns2();
            mSecondChoice.setText(mAnswer2);




        }
        else if (yourAnswer==2){

            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_2,Toast.LENGTH_LONG);
            mytoast.show();

            mQuestion = mBluePrint[1].getStory();
            mStory.setText(mQuestion);

            mAnswer1=mBluePrint[1].getAns1();
            mFirstChoice.setText(mAnswer1);

            mAnswer2=mBluePrint[1].getAns2();
            mSecondChoice.setText(mAnswer2);


        }
        else if (yourAnswer==3){

            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_3,Toast.LENGTH_LONG);
            mytoast.show();

            mQuestion = mBluePrint[2].getStory();
            mStory.setText(mQuestion);

            mAnswer1=mBluePrint[2].getAns1();
            mFirstChoice.setText(mAnswer1);

            mAnswer2=mBluePrint[2].getAns2();
            mSecondChoice.setText(mAnswer2);



        }

        else if (yourAnswer==4){
            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_4,Toast.LENGTH_LONG);
            mytoast.show();
            mQuestion = mBluePrint[3].getStory();
            mStory.setText(mQuestion);

            //make the button invisable
            mFirstChoice.setVisibility(View.GONE);
            mSecondChoice.setVisibility(View.GONE);


        }
        else if (yourAnswer==5){
            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_5,Toast.LENGTH_LONG);
            mytoast.show();
            mQuestion = mBluePrint[4].getStory();
            mStory.setText(mQuestion);

            //make the button invisable
            mFirstChoice.setVisibility(View.GONE);
            mSecondChoice.setVisibility(View.GONE);

        }


        else if (yourAnswer==6){
            Toast mytoast=Toast.makeText(getApplicationContext(),R.string.toast_6,Toast.LENGTH_LONG);
            mytoast.show();
            mQuestion = mBluePrint[5].getStory();
            mStory.setText(mQuestion);

            //make the button invisable
            mFirstChoice.setVisibility(View.GONE);
            mSecondChoice.setVisibility(View.GONE);


        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("YourAnswer",yourAnswer);


    }


}

