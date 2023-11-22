package sham.dawod.shamapplication.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import sham.dawod.shamapplication.data.usersTable.MyUser;

/** واجهة استعلامات على جدول المعطيات*/
@Dao
public interface MyTaskQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return *قائمة من مهمات
     */
    @Query("SELECT * FROM MyTask")
    List<MyTask> getAllTask();

    /**
     *استخراج المهمات حسب المستعمل وهل تمت ام لا ومرتبة حسب الاهمية
     * @param userid_p
     * @param isCompleted_p
     * @return
     */

    @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p" +
            " ORDER BY importance DESC" )
    List<MyTask> getAllTaskOrederBY(long userid_p, boolean isCompleted_p);

    /**
     * استخراج المهمات حسب المستعمل مرتبة حسب الوقت
     * @param userId_p
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userId_p " +
            "ORDER BY time DESC" )
    List<MyTask> getAllTaskByUser(long userId_p);


    /**
     * ادخال مهامات
     * @param tasks * مجموعة مهمات
     */

    @Insert
    void insertAll(MyTask... tasks);// الثلاثة نقاط:تعني ادخال مجموعة من الكائنات

    /**
     * تعديل المهمات
     * @param tasks * مجموعة مهمات للتعديل (التعديل  حسب المفاتح الرئيسي)
     */

    @Update
    void update(MyTask ... tasks);

    /**
     * حذف مهمات
     * @param tasks * حذف مهمات (  حسب المفاتح الرئيسي)
     */

    @Delete
    void deleteTask(MyTask ... tasks);


    @Query("DELETE FROM MyTask WHERE keyid=:id")
    void deleteTask(long id );










}
