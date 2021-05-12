package android.maikiencuong.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AddressDao {

    @Query("SELECT * FROM Address")
    List<Address> getAll();

    @Query("SELECT * FROM Address WHERE id IN (:addressIds)")
    List<Address> loadAllByIds(int[] addressIds);

    @Query("SELECT * FROM Address WHERE name LIKE :name LIMIT 1")
    Address findByName(String name);

    @Insert
    void insertAll(Address... addresses);

    @Delete
    void delete(Address address);

}
