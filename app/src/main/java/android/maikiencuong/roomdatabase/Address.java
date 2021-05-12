package android.maikiencuong.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Address")
public class Address {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public Address() {
    }

    public Address(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Address(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
