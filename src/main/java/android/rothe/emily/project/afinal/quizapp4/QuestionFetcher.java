package android.rothe.emily.project.afinal.quizapp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.rothe.emily.project.afinal.quizapp4.Database.DataBaseHelper.QuestionTable;
import android.rothe.emily.project.afinal.quizapp4.Database.QuestionCursorWrapper;
import android.rothe.emily.project.afinal.quizapp4.Database.QuestionDataBaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.lang.*;

/**
 * Created by EmilyHP on 1/9/2017.
 */

public class QuestionFetcher {
    private static QuestionFetcher sQuestionFetcher;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private Question q1 = new Question(1, R.string.question1, true, false);
    private Question q2 = new Question(2, R.string.question2, false, false);
    private Question q3 = new Question(3, R.string.question3, false, false);
    private Question q4 = new Question(4, R.string.question4, true, false);
    private Question q5 = new Question(5, R.string.question5, true, false);
    private Question q6 = new Question(6, R.string.question6, false, false);
    private Question q7 = new Question(7, R.string.question7, true, false);
    private Question q8 = new Question(8, R.string.question8, true, false);
    private Question q9 = new Question(9, R.string.question9, false, false);
    private Question q10 =new Question(10, R.string.question10, false, false);

    public static QuestionFetcher get(Context context) {
        if (sQuestionFetcher == null) {
            sQuestionFetcher = new QuestionFetcher(context);
        }
        return sQuestionFetcher;
    }

    protected QuestionFetcher(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new QuestionDataBaseAdapter(mContext).getWritableDatabase();
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);
    }

    public void addQuestion(Question q) {
        ContentValues values = getContentValues(q);

        mDatabase.insert(QuestionTable.NAME, null, values);
    }

    public List<Question> getQuestion() {
        List<Question> questionBank = new ArrayList<>();

        QuestionCursorWrapper cursor = queryQuestions(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                questionBank.add(cursor.getQuestion());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return questionBank;
    }


    public Question getQuestion(int id) {
        QuestionCursorWrapper cursor = queryQuestions(
                QuestionTable.Cols.ID + " = ?",
                new String[] { String.valueOf(id) }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getQuestion();
        } finally {
            cursor.close();
        }
    }

    public void updateQuestion(Question question) {
        String idString = String.valueOf(question.getId());
        ContentValues values = getContentValues(question);

        mDatabase.update(QuestionTable.NAME, values,
                QuestionTable.Cols.ID + " = ?",
                new String[] { idString });
    }

    private static ContentValues getContentValues(Question question) {
        ContentValues values = new ContentValues();
        values.put(QuestionTable.Cols.ID, question.getId());
        values.put(QuestionTable.Cols.TEXT_RES_ID, question.getTextResId());
        values.put(QuestionTable.Cols.ANSWER_TRUE, question.isAnswerTrue() ? 1 : 0);
        values.put(QuestionTable.Cols.BOX_CHECKED, question.isQuestionChecked() ? 1 : 0);

        return values;
    }

    private QuestionCursorWrapper queryQuestions(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                QuestionTable.NAME,
                null,
                whereClause,
                whereArgs,
                null, null, null
        );

        return new QuestionCursorWrapper(cursor);
    }
}
