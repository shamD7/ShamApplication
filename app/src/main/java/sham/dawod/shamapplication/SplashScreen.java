package sham.dawod.shamapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;

public class SplashScreen extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //456456456465
        setContentView(R.layout.splashscreen);


        Log.d("SD", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        //1. بناء قاعدة بيانات وارجاع مؤشر عليها
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //1.مؤشر لكائن عمليات الجدول ا
        MySubjectQuery MySubjectQuery = db.getMySubjectQuery();
        //3. بناء كائن من نوع جدول
        MySubject s1 = new MySubject();
        s1.title = "Math";
        MySubject s2 = new MySubject();
        s2.title = "Computers";
        //4.اضافة كائن للجدول
        MySubjectQuery.insertAll(s1);
        MySubjectQuery.insertAll(s2);
        //5.فحص هل تم حفظ ما سبق(استخراج وطباعة جميع معطيات جدول المواضيع
        List<MySubject> allSubject = MySubjectQuery.getAllSubject();
        for (MySubject s : allSubject) {
            Log.d("sham", s.title);
            Toast.makeText(this, s.title, Toast.LENGTH_LONG);
        }
        //start next activity (screen) automatically after period of time

        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //to open new activity from current to next
                Intent i = new Intent(SplashScreen.this, SignInActivity.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r, 3000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SD", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SD", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SD", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SD", "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SD", "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemSettings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

        }
        if (item.getItemId() == R.id.itemSignOut)
        {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();

        }
        return true;

    }
}







