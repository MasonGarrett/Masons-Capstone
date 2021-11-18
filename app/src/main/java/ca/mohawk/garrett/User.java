package ca.mohawk.garrett;

import android.content.Context;

public class User {
    private int id;
    private String username;
    private String email;
    private String favTeam;
    private Context context;

    public User(int id, String username, String email, String favteam, Context context){
        this.id = id;
        this.username = username;
        this.email = email;
        this.favTeam = favteam;
        this.context = context;
    }

    public int getID(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFavTeam() {
        return favTeam;
    }

    public Context getContext() {
        return context;
    }
}
