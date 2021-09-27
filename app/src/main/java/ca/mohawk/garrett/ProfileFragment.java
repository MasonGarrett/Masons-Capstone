package ca.mohawk.garrett;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private String username;

    public ProfileFragment(String username){
        this.username = username;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView usernameLabel = v.findViewById(R.id.usersUsername);
        usernameLabel.setText(username);
        return v;
    }
}
