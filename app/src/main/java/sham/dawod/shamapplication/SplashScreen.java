package sham.dawod.shamapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;

public class SplashScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //456456456465
        setContentView(R.layout.activity_main);
        Log.d("SD","onCreate" );
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //1. بناء قاعدة بيانات وارجاع مؤشر عليها
        AppDatabase db =AppDatabase.getDB(getApplicationContext());
        //1.مؤشر لكائن عمليات الجدول ا
        MySubjectQuery MySubjectQuery = db.getMySubjectQuery();
        //3. بناء كائن من نوع جدول
        MySubject s1=new MySubject();
        s1.title="Math";
        MySubject s2=new MySubject();
        s2.title="Computers";
        //4.اضافة كائن للجدول
        MySubjectQuery.insertAll(s1);
        MySubjectQuery.insertAll(s2);
        //5.فحص هل تم حفظ ما سبق(استخراج وطباعة جميع معطيات جدول المواضيع
        List<MySubject> allSubject = MySubjectQuery.getAllSubject();
        for (MySubject s:allSubject)
             {
                 Log.d("sham",s.title);
                 Toast.makeText(this,s.title,Toast.LENGTH_LONG);
            
        }


    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("SD","onRestart" );
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("SD","onResume" );
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("SD","onPause" );
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("SD","onStop" );
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("SD","onDestroy" );
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }
}