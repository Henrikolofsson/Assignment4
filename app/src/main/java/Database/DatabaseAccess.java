package Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.BoolRes;

import java.util.ArrayList;
import java.util.List;

import Entity.User;

@Dao
public interface DatabaseAccess {

    @Insert
    void addUser(User... user);

    @Insert
    void removeUser(User... user);

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password")
    User logIn(String username, String password);

    @Query("SELECT * FROM user_table WHERE username = :username")
    User getUserInfo(String username);

    @Query("SELECT * FROM user_table")
    List<User> getUsers();

}
