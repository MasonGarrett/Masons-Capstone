package ca.mohawk.garrett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText username, email, password, confirmPassword;
    Button signUpButton;
    TextView signInButton;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Setup custom spinner.
        Spinner colouredSpinner = findViewById(R.id.favouriteTeam);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.lcs_teams, R.layout.colour_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        colouredSpinner.setAdapter(adapter);
        colouredSpinner.setOnItemSelectedListener(this);

        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        confirmPassword = findViewById(R.id.confirmPasswordInput);

        signUpButton = findViewById(R.id.registerButton);
        signInButton = findViewById(R.id.signInButton);

        myDB = new DBHelper(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = username.getText().toString();
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();
                String confirmPasswordInput = confirmPassword.getText().toString();

                if(userInput.equals("") || emailInput.equals("") || passwordInput.equals("") || confirmPasswordInput.equals("")){
                    Toast.makeText(Registration.this, "Input fields cannot be blank!", Toast.LENGTH_SHORT).show();
                }
                else if (!passwordInput.equals(confirmPasswordInput)){
                    Toast.makeText(Registration.this, "Password inputs do not match!", Toast.LENGTH_SHORT).show();
                }
                else if (myDB.checkUsername(userInput)){
                    Toast.makeText(Registration.this, "Username is already in use.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.createNewUser(userInput, emailInput, passwordInput);
                    if(result){
                        Toast.makeText(Registration.this, "Account created!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Registration.this, "Account creation failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}