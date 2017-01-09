package android.rothe.emily.project.afinal.quizapp4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by EmilyHP on 12/30/2016.
 */

public class mainQuiz extends AppCompatActivity{
    private static final String TAG = "mainQuiz";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;

    private int questionsAnswered = 1;
    private int points = 0;

    private Context context;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private Button mSkipButton;
    private TextView mQuestionTextView;

    private boolean mIsCheater;
    private QuestionFetcher mQuestionFetcher = new QuestionFetcher(getContext());


    private void updateQuestion() {
        if (questionsAnswered > 10){
            //launch score screen
        }
        else {
            questionsAnswered = questionsAnswered + 1;
            mQuestionFetcher.getQuestion(questionsAnswered);
            mQuestionTextView.setText(mQuestionFetcher.getQuestion(questionsAnswered).getTextResId());
        }
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionFetcher.getQuestion(questionsAnswered).isAnswerTrue();

        int messageResId = 0;

        if (mIsCheater) {
            messageResId = R.string.judgement_toast;
        } else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main_quiz);


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                questionsAnswered = questionsAnswered + 1;
                mIsCheater = false;
                updateQuestion();
                if (mQuestionFetcher.getQuestion(questionsAnswered).isAnswerTrue()) {
                    points = points + 1;
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                questionsAnswered = questionsAnswered + 1;
                mIsCheater = false;
                updateQuestion();
                if (!mQuestionFetcher.getQuestion(questionsAnswered).isAnswerTrue()) {
                    points = points + 1;
                }
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = mQuestionFetcher.getQuestion(questionsAnswered).isAnswerTrue();
                Intent i = CheatActivity.newIntent(mainQuiz.this, answerIsTrue);
                startActivityForResult(i, REQUEST_CODE_CHEAT);
            }
        });
        updateQuestion();

        mSkipButton = (Button) findViewById(R.id.skip_button);
        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionsAnswered = questionsAnswered + 1;
                updateQuestion();
            }
        });

        if (savedInstanceState != null) {
            questionsAnswered = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            if(data == null) {
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, questionsAnswered);
    }

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, mainQuiz.class);
        return i;
    }
}
