package sham.dawod.shamapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import sham.dawod.shamapplication.R;

public class MainActivity3 extends AppCompatActivity {
//spnr1 تعريف لصفة الكائن المرئي
    private Spinner spnrSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //spnr2 وضع مؤشر الصفة على الكائن المرئي الموجود بواجهة المستعمل
        spnrSubject=findViewById(R.id.spnrSubject);
        //spnr3 بناء الوسيط وتحديد واجهة تنسيق لمعطى واحد
        ArrayAdapter <String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data source مصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String []ar={"Math","CS","Phs","Arb","Eng"};
        //spnr5 تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr6 ربط الكائن المرئي بالوسيط
        spnrSubject.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.itemSettings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

        }
        if (item.getItemId() == R.id.itemSignOut)
        {
            Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();

        }
        if (item.getItemId()==R.id.ItemAddTask)
        {
            Intent i = new Intent(MainActivity3.this, AddTaskActivity.class);
            startActivity(i);
        }
        return true;

    }

}