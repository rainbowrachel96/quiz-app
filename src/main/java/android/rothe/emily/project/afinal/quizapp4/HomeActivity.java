package android.rothe.emily.project.afinal.quizapp4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.rothe.emily.project.afinal.quizapp4.Database.LoginDataBaseAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity
{

    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // create the instance of Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Reference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);



        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUp=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intentSignUp);
            }
        });
    }


    // Method to handleClick Event of Sign In Button
    public void signIn(View V)
    {

        final Dialog dialog = new Dialog(HomeActivity.this);

        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the References of views
        final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                // get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(HomeActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    dialog.dismiss();

                    Intent intentStartQuiz = new Intent(getApplicationContext(), StartQuiz.class);
                    startActivity(intentStartQuiz);
                }
                else
                {

                    Toast.makeText(HomeActivity.this, "User Name and Password do not Match", Toast.LENGTH_LONG).show();
                }

            }
        });


        dialog.show();

    }



    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        // Close The Database
        loginDataBaseAdapter.close();
    }


}
