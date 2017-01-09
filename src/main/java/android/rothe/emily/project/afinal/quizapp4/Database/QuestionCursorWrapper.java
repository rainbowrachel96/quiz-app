package android.rothe.emily.project.afinal.quizapp4.Database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.rothe.emily.project.afinal.quizapp4.Database.DataBaseHelper.QuestionTable;
import android.rothe.emily.project.afinal.quizapp4.Question;

import java.util.UUID;

/**
 * Created by EmilyHP on 1/9/2017.
 */

public class QuestionCursorWrapper extends CursorWrapper {
    public QuestionCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Question getQuestion() {
        String id = getString(getColumnIndex(QuestionTable.Cols.ID));
        String textResId = getString(getColumnIndex(QuestionTable.Cols.TEXT_RES_ID));
        int isTrue = getInt(getColumnIndex(QuestionTable.Cols.ANSWER_TRUE));
        int isChecked = getInt(getColumnIndex(QuestionTable.Cols.BOX_CHECKED));

        Question question = new Question(Integer.parseInt(id));
        question.setTextResId(Integer.parseInt(textResId));
        question.setAnswerTrue(isTrue != 0);
        question.setBoxChecked(isChecked != 0);

        return question;
    }
}
