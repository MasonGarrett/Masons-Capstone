package ca.mohawk.garrett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button logInButton;
    TextView signUpButton;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);

        logInButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);

        myDB = new DBHelper(this);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = username.getText().toString();
                String passwordInput = password.getText().toString();

                if(userInput.equals("") || passwordInput.equals("")){
                    Toast.makeText(Login.this, "Input fields cannot be blank!", Toast.LENGTH_SHORT).show();
                }
                else if(!myDB.checkUserPassword(userInput, passwordInput)){
                    Toast.makeText(Login.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // NOTE: Send user ID to main activity to track users info.
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("username", userInput);
                    startActivity(intent);
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
            }
        });

    }
}