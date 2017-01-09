package android.rothe.emily.project.afinal.quizapp4;

import java.util.UUID;

/**
 * Created by EmilyHP on 12/30/2016.
 */

public class Question {

    private int mId;
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mBoxChecked;
    private int mCurrentIndex;

    public Question(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isQuestionChecked() {
        return mBoxChecked;
    }

    public void setBoxChecked(boolean boxChecked) {
        mBoxChecked = boxChecked;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public Question (int id, int textResId, boolean answerTrue, boolean boxChecked){
        mId = id;
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mBoxChecked = boxChecked;
    }

    public int getCurrentIndex() {
        return mCurrentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        mCurrentIndex = currentIndex;
    }
}
