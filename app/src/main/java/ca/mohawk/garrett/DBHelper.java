package ca.mohawk.garrett;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DBHelper is a class that creates a users table and provides helpful methods
 * to help login and register users.
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * DBHelper constructor that creates a database called "capstone.db".
     * @param context
     */
    public DBHelper(Context context) {
        super(context, "capstone.db", null, 1);
    }

    /**
     * onCreate method creates the users table in the capstone database.
     * @param myDB
     */
    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create TABLE users(_id integer primary key, username Text, email Text, password Text)");
    }

    /**
     * onUpgrade method drops the users table if the version is not correct.
     * @param myDB
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }

    /**
     * createNewUser method creates a new and inserts the users info into the users table.
     * @param username
     * @param email
     * @param password
     * @return - whether or not the user was successfully added to the database.
     */
    public Boolean createNewUser(String username, String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * checkUsername method checks to see if the entered username is in the database.
     * @param username
     * @return - whether or not the username was found in the database.
     */
    public Boolean checkUsername(String username){
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * checkUserPassword method checks to see if the users login information matches
     * with a user in the database.
     * @param username
     * @param password
     * @return - whether or not the users information matches a user in the database.
     */
    public Boolean checkUserPassword(String username, String password){
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }
}
