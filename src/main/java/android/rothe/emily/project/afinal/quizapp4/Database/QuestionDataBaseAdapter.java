package android.rothe.emily.project.afinal.quizapp4.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.rothe.emily.project.afinal.quizapp4.Database.DataBaseHelper.QuestionTable;

/**
 * Created by EmilyHP on 1/9/2017.
 */

public class QuestionDataBaseAdapter extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "question.db";
    static final int DATABASE_VERSION = 1;

    public QuestionDataBaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + QuestionTable.NAME + "(" +
        "_id integer primary key autoincrement, " +
                QuestionTable.Cols.ID + "," +
                QuestionTable.Cols.TEXT_RES_ID + "," +
                QuestionTable.Cols.ANSWER_TRUE + "," +
                QuestionTable.Cols.BOX_CHECKED +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


}
