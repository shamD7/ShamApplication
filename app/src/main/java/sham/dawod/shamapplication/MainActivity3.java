package sham.dawod.shamapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import sham.dawod.shamapplication.R;
import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;
import sham.dawod.shamapplication.data.MyTaskTable.MyTask;
import sham.dawod.shamapplication.data.MyTaskTable.MyTaskQuery;

public class MainActivity3 extends AppCompatActivity {
//spnr1 تعريف لصفة الكائن المرئي
    private Spinner spnrSubject;
    private ListView lstvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
        lstvTasks=findViewById(R.id.lstvTasks);

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

    @Override
    protected void onResume()
    {
        super.onResume();
        initSubjectSpnr();
    }

    /**
     * عملية تجهيز السبنر بالمواضيع
     */
    private void initSubjectSpnr()
        {

            AppDatabase db=AppDatabase.getDB(getApplicationContext());// قاعدة بناء
            MySubjectQuery subjectQuery=db.getMySubjectQuery();//  عمليات جدول المواضيع
            List<MySubject> allSubjects=subjectQuery.getAllSubject();// استخراج// جميع المواضيع
            // قاعدة بناء
            ArrayAdapter <String> SubjectAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

            SubjectAdapter.add("ALL");//ستظهر اولا بالسبنر تعني عرض جميع المهمات
            for (MySubject subject:allSubjects)//  اضافة المواضبع للوسيط
            {
                SubjectAdapter.addAll(subject.title);
            }

            spnrSubject.setAdapter(SubjectAdapter);//ربط السبنر بالوسيط 

    }
    private void initAllListView()
    {

        AppDatabase db=AppDatabase.getDB(getApplicationContext());// قاعدة بناء
        MyTaskQuery taskQuery=db.getMyTaskQuery();
        List<MyTask> allTasks=taskQuery.getAllTask();
        ArrayAdapter <String>TaskAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

        TaskAdapter.addAll(allTasks);
        lstvTasks.setAdapter(TaskAdapter);

    }

}