package sham.dawod.shamapplication.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;
import sham.dawod.shamapplication.data.MyTaskTable.MyTask;
import sham.dawod.shamapplication.data.MyTaskTable.MyTaskQuery;
import sham.dawod.shamapplication.data.usersTable.MyUser;
import sham.dawod.shamapplication.data.usersTable.MyUserQuery;
/*
تعريف الجداول ورفم النسخة
version
ند تغيير اي شيء يخص الجداول او دوال علينا تغيير رقم الاصدار ليتم بناء قاعدة البيانات من جديد
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 1)
/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
public abstract class AppDatabase extends RoomDatabase
{

    private static AppDatabase db;  /**كائن للتعامل مع قاعدة البيانات */
    /**
     *
     * @return * يعيد كائن لعمليات جدول المستعملين
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     *
     * @return * يعيد كائن لعمليات جدول المواضيع
     */
    public abstract MySubjectQuery getMySubjectQuery();

    /**
     *
     * @return *يعيد كائن لعمليات جدول المهمات
     */
    public abstract MyTaskQuery getMyTaskQuery();

    /**
     *بناء قاعدة الباينات واعادة كائن ياشر عليها
     * @param context
     * @return
     */

    public static AppDatabase getDB(Context context)
    {
        if(db==null)
        {
            db = Room.databaseBuilder(context,
                            AppDatabase.class, "sham-database-name")//اسم قاعدة البيانات
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}

