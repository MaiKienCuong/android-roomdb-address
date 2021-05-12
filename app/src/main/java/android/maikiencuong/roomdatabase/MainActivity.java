package android.maikiencuong.roomdatabase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnSave, btnCancel;
    private TextView tvAdd;
    private ListView listView;
    private AddressAdapter adapter;
    private List<Address> addressList;
    private int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        tvAdd = findViewById(R.id.tvAdd);
        listView = findViewById(R.id.listView);

        addressList = new ArrayList<>();
//        addressList.add(new Address("Hà Nội"));
//        addressList.add(new Address("Hồ Chí Minh"));
//
//        for (Address address : addressList) {
//            dbHandler.addAddress(address);
//        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "address_db_room")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        adapter = new AddressAdapter(addressList, MainActivity.this, db);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                for (int i = 0; i < parent.getChildCount(); i++) {
                    parent.getChildAt(i).setBackgroundColor(Color.WHITE);
                }
                view.setBackgroundColor(Color.argb(100, 255, 165, 0));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address address = new Address(tvAdd.getText().toString().trim());
                if (!address.getName().trim().isEmpty()) {
                    db.addressDao().insertAll(address);
                    adapter.notifyDataSetChanged();
                    tvAdd.setText("");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAdd.setText("");
                adapter.notifyDataSetChanged();
            }
        });
    }

}