package android.rothe.emily.project.afinal.quizapp4;

import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by EmilyHP on 1/2/2017.
 */

public class QuizHostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_host_frame);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new ListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
