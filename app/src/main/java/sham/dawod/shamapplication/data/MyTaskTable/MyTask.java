package sham.dawod.shamapplication.data.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
/**
 * فئة تمثل مهمة
 */


public class MyTask
{
    @PrimaryKey(autoGenerate = true)
    /**رقم المهمة*/
    public long keyid;
    /**درجة اهمية المهمة */
    public int importance;
    /**نص المهمة*/
    public String text;
    /**عنوان المهمة*/
    public String shortTitle;
    /**رقم موضوع المهمة*/
    public long subjId;
    /**رقم المستعمل الذي اضاف المهمة*/
    public long userId;
    /**زمن بناء المهمة*/
    public long time ;
    /**هل تمت المهمة*/
    public boolean isCompleted;

    @Override
    public String toString() {
        return "MyTask{" +
                "keyid=" + keyid +
                ", importance=" + importance +
                ", text='" + text + '\n' +
                ", subjId=" + subjId +
                ", userId=" + userId +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
