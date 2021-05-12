package android.maikiencuong.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Address.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AddressDao addressDao();

}