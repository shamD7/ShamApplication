package sham.dawod.shamapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
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
    private ImageButton IbtnAdd;



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
        IbtnAdd=findViewById(R.id.IbtnAdd);
        IbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity3.this, AddTaskActivity.class);
                startActivity(i);

            }
        });

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

            spnrSubject.setAdapter(SubjectAdapter);// ربط السبنر بالوسيط
            spnrSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    // استخراج الموضوع حسب رقمه الترتيبي i
                    String item = SubjectAdapter.getItem(i);
                    if (item.equals("ALL"))//هذا يعني اعترض جميع المهام
                    {
                        initAllListView();
                    } else {
                        //استخراج كائن الموضوع الذي اخترناه لاسنخراج رقمه id
                        MySubject subject = subjectQuery.checkSubject(item);
                        //استدعاء العملية التي تجهز القائمة حسب رقم الموضوع
                        initListViewBySubjId(subject.key_id);

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView)
                {


                }
            });




    }
    private void initAllListView() {

        AppDatabase db = AppDatabase.getDB(getApplicationContext());// قاعدة بناء
        MyTaskQuery taskQuery = db.getMyTaskQuery();
        List<MyTask> allTasks = taskQuery.getAllTask();
        ArrayAdapter<MyTask> TaskAdapter = new ArrayAdapter<MyTask>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line);

        TaskAdapter.addAll(allTasks);
        lstvTasks.setAdapter(TaskAdapter);
        lstvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                showPopUpMenu(view,TaskAdapter.getItem(i));

            }
        });
    }
    private void initListViewBySubjId(long key_id)
    {
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        MyTaskQuery taskQuery=db.getMyTaskQuery();
        // جب اضافة عملية تعيد جميع المهمات حسب رقم الموضوع
        List<MyTask> allTasks =taskQuery.getTasksBySubjId(key_id);
        ArrayAdapter <MyTask>TaskAdapter=new ArrayAdapter<MyTask>(this, android.R.layout.simple_list_item_1);
        TaskAdapter.addAll(allTasks);
        lstvTasks.setAdapter(TaskAdapter);

    }
    public void showPopUpMenu(View v,MyTask item)
    {
        //بناء قائمة popup menu
        PopupMenu popup=new PopupMenu(this,v);//لكائن الذي سبب فتح القائمة
        //ملف القائمة
        popup.inflate(R.menu.popup_menu);
        //اضافة معالج حدث لاختيار عنصر من القائمة
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.ItemAddTask) {
                    //
                    Toast.makeText(MainActivity3.this, "Add", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity3.this, AddTaskActivity.class);
                    startActivity(i);
                }
                if (menuItem.getItemId() == R.id.itmDelete) {
                    Toast.makeText(MainActivity3.this, "Delete", Toast.LENGTH_SHORT).show();

                }
                if (menuItem.getItemId() == R.id.itmEdit) {
                    Toast.makeText(MainActivity3.this, "Edit", Toast.LENGTH_SHORT).show();
                }
                return true;

            }

        });
        popup.show();//فتح وعرض القائمة

    }






}