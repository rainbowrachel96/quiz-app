package android.rothe.emily.project.afinal.quizapp4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by EmilyHP on 12/30/2016.
 */

public class StartQuiz extends AppCompatActivity{

    private Button mStartButton;

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, StartQuiz.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_quiz);

        mStartButton = (Button) findViewById(R.id.start_quiz_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = mainQuiz.newIntent(StartQuiz.this);
                startActivity(i);
            }
        });
    }
}
