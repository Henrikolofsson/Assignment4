package henrik.mau.assignment4;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import Database.Database;
import Database.DatabaseAccess;
import Entity.User;

public class DBAccess {
    private static final String DATABASE_NAME = "ASSIGNMENT4";
    private Database database;
    private DatabaseAccess databaseAccess;
    private Controller controller;

    public DBAccess(Context context){
        database = Room.databaseBuilder(context, Database.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
        databaseAccess = database.databaseAccess();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void addUser(User... user){
        databaseAccess.addUser(user);
    }

    public User logIn(String username, String password){
       return databaseAccess.logIn(username, password);
    }

    public List<User> getUsers(){
        return databaseAccess.getUsers();
    }
}
