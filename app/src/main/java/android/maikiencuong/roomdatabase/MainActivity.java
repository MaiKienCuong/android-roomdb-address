package android.maikiencuong.roomdatabase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "address_db_room")
                .allowMainThreadQueries().build();

        AddressDao addressDao = db.addressDao();
        addressDao.insertAll(new Address("Ho Chi Minh"));
        addressDao.getAll().forEach(add -> Log.i("address:", add.toString()));

    }

}