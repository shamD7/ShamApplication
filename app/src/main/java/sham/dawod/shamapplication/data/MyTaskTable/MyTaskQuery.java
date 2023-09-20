package sham.dawod.shamapplication.data.MyTaskTable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


public interface MyTaskQuery
{
    @Query("SELECT * FROM MyTask")
    List<MyTask> getAllTask();

    @Insert
    void insertAll(MyTask... tasks);// الثلث نقاط:تعني ادخال مجموعة من الكائنات

    @Delete
    void delete(MyTask task);

    @Query("Delete From MyTask WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(MyTask myTask);

    @Update
    void update(MyTask...values);

}
