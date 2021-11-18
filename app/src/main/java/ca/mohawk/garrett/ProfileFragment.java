package ca.mohawk.garrett;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private User user;

    public ProfileFragment(User user){
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView usernameLabel = v.findViewById(R.id.usersUsername);
        TextView teamLabel = v.findViewById(R.id.usersTeam);

        usernameLabel.setText(user.getUsername());
        teamLabel.setText(user.getFavTeam());
        return v;
    }
}
