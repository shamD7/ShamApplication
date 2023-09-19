package sham.dawod.shamapplication.data.usersTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Entity=Table=جدول

@Entity //نضعها عندما نريد ان نتعامل مع هذه الفئة كجدول معطيات
public class MyUser {
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل تلقائي
    public long keyid;
    @ColumnInfo(name = "fullName") //اعطاء اسم جديد للعامود (الصفة في الجدول)
    public String fullName;
    public String email;// بحالة لم يتم اعطاء اسم للعامود يكون اسم الصفة هو اسم العامود
    public String phone;
    public String passw;


    @Override
    public String toString() {
        return "MyUser{" +
                "keyid=" + keyid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }

}