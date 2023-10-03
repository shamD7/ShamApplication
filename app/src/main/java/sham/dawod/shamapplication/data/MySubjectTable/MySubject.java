package sham.dawod.shamapplication.data.MySubjectTable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
/**
 * فئة تمثل مهمة
 */
public class MySubject
{
    @PrimaryKey(autoGenerate = true)
    /**رقم المهمة*/
    public long key_id;
    public String title;

    @Override
    public String toString() {
        return "MySubject{" +
                "title='" + title + '\'' +
                '}';
    }
}
