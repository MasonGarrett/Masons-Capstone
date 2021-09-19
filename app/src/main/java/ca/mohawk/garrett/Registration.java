package ca.mohawk.garrett;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Spinner colouredSpinner = findViewById(R.id.favouriteTeam);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.lcs_teams, R.layout.colour_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        colouredSpinner.setAdapter(adapter);
        colouredSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}