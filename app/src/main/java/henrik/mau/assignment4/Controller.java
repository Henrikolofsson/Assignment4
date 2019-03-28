package henrik.mau.assignment4;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;

import Entity.User;
import Fragment.*;

import static android.content.ContentValues.TAG;

public class Controller {
    private MainActivity activity;
    private DBAccess dbAccess;

    private StartFragment startFragment;
    private DataFragment dataFragment;
    private LogInFragment logInFragment;
    private CreateUserFragment createUserFragment;
    private int stepsTakenSinceReboot;


    public Controller(MainActivity activity){
        this.activity = activity;
        initializeFragments();
        initializeDatabase();
        setFragment("LogInFragment");
    }

    private void initializeFragments(){
        initializeDataFragment();
        initializeLogInFragment();
        initializeStartFragment();
        initializeCreateUserFragment();
    }

    private void initializeDataFragment(){
        dataFragment = (DataFragment) activity.getFragment("DataFragment");
        if(dataFragment == null){
            dataFragment = new DataFragment();
            activity.addFragment(dataFragment, "DataFragment");
            dataFragment.setActiveFragment("LogInFragment");
        }
    }

    private void initializeLogInFragment(){
        logInFragment = (LogInFragment) activity.getFragment("LogInFragment");
        if(logInFragment == null){
            logInFragment = new LogInFragment();
        }
        logInFragment.setController(this);
    }

    private void initializeStartFragment(){
        startFragment = (StartFragment) activity.getFragment("StartFragment");
        if(startFragment == null){
            startFragment = new StartFragment();
        }
        startFragment.setController(this);
    }

    private void initializeCreateUserFragment(){
        createUserFragment = (CreateUserFragment) activity.getFragment("CreateUserFragment");
        if(createUserFragment == null){
            createUserFragment = new CreateUserFragment();
        }
        createUserFragment.setController(this);
    }

    private void initializeDatabase(){
        dbAccess = new DBAccess(activity);
    }


    private void setFragment(String tag) {
        switch (tag) {
            case "StartFragment":
                setFragment(startFragment, tag);
                break;

            case "LogInFragment":
                setFragment(logInFragment, tag);
                break;

            case "CreateUserFragment":
                setFragment(createUserFragment, tag);
                break;
        }
    }

    public void setCreateUserFragment(){
        setFragment("CreateUserFragment");
    }

    public void setLogInFragment(){
        setFragment("LogInFragment");
    }

    private void setFragment(Fragment fragment, String tag) {
        activity.setFragment(fragment, tag);
        dataFragment.setActiveFragment(tag);
    }

    public void logIn(final String username, final String password){
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user;
                user = dbAccess.logIn(username, password);
                if(user != null){
                    activity.registerStepsCounter();
                }
            }
        }).start();
    }

    public void createUser(final String username, final String password){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //dbAccess.addUser(new User(username, password));
                ArrayList<User> users = (ArrayList<User>) dbAccess.getUsers();
                for(User u : users){
                    Log.d("USER", u.toString());
                }
            }
        }).start();
        setLogInFragment();
    }

    public boolean onBackPressed() {
        return false;
    }

    public int getStepsTakenSinceReboot() {
        return stepsTakenSinceReboot;
    }

    public void setStepsTakenSinceReboot(int stepsTakenSinceReboot) {
        this.stepsTakenSinceReboot = stepsTakenSinceReboot;
    }
}
