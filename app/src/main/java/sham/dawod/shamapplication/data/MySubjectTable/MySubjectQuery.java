package sham.dawod.shamapplication.data.MySubjectTable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import sham.dawod.shamapplication.data.MyTaskTable.MyTask;

@Dao  /** واجهة استعلامات على جدول المعطيات*/
public interface MySubjectQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return *قائمة من مهمات
     */
    @Query("SELECT * FROM MySubject")
    List<MySubject> getAllSubject();
;
    /**
     * ادخال مهامات
     * @param subject
     */

    @Insert
    void insertAll(MySubject... subject);// الثلاثة نقاط:تعني ادخال مجموعة من الكائنات

    /**
     * تعديل المهمات
     *@param subjects  * مجموعة مهمات للتعديل (التعديل  حسب المفاتح الرئيسي)
     */

    @Update
    void update(MySubject... subjects);

    /**
     * حذف مهمات
     * @param subject * حذف مهمات (  حسب المفاتح الرئيسي)
     */

    @Delete
    void deleteTask(MySubject... subject);


    @Query("DELETE FROM MySubject WHERE key_id=:id")
    void deleteTask(long id );






}
