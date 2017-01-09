package android.rothe.emily.project.afinal.quizapp4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.rothe.emily.project.afinal.quizapp4.Database.DataBaseHelper;
import android.rothe.emily.project.afinal.quizapp4.Database.QuestionCursorWrapper;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by EmilyHP on 1/8/2017.
 */

public class ListFragment extends FragmentActivity {

    private SQLiteDatabase mDatabase;
    private QuestionFetcher mQuestionFetcher = new QuestionFetcher(getApplicationContext());

    private CheckBox mCheckBox;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private CheckBox mCheckBox5;
    private CheckBox mCheckBox6;
    private CheckBox mCheckBox7;
    private CheckBox mCheckBox8;
    private CheckBox mCheckBox9;
    private CheckBox mCheckBox10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_questions, container, false);

        mCheckBox = (CheckBox) v.findViewById(R.id.checkBox);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(1, R.string.question1, true, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox2 = (CheckBox) v.findViewById(R.id.checkBox2);
        mCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(2, R.string.question2, false, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox3 = (CheckBox) v.findViewById(R.id.checkBox3);
        mCheckBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(3, R.string.question3, false, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox4 = (CheckBox) v.findViewById(R.id.checkBox4);
        mCheckBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(4, R.string.question4, true, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox5 = (CheckBox) v.findViewById(R.id.checkBox5);
        mCheckBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(5, R.string.question5, true, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox6 = (CheckBox) v.findViewById(R.id.checkBox6);
        mCheckBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(6, R.string.question6, false, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox7 = (CheckBox) v.findViewById(R.id.checkBox7);
        mCheckBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(7, R.string.question7, true, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox8 = (CheckBox) v.findViewById(R.id.checkBox8);
        mCheckBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(8, R.string.question8, true, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox9 = (CheckBox) v.findViewById(R.id.checkBox9);
        mCheckBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(9, R.string.question9, false, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });

        mCheckBox10 = (CheckBox) v.findViewById(R.id.checkBox10);
        mCheckBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Question question = new Question(10, R.string.question10, false, isChecked);
                mQuestionFetcher.updateQuestion(question);
            }
        });


        return v;
    }

    private QuestionCursorWrapper queryQuestions(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DataBaseHelper.QuestionTable.NAME,
                null,
                whereClause,
                whereArgs,
                null, null, null
        );

        return new QuestionCursorWrapper(cursor);
    }

}

