package Database;
import android.arch.persistence.room.RoomDatabase;

import Entity.User;

@android.arch.persistence.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract DatabaseAccess databaseAccess();
}
