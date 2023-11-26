package sham.dawod.shamapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;
import sham.dawod.shamapplication.data.MyTaskTable.MyTask;
import sham.dawod.shamapplication.data.usersTable.MyUserQuery;

public class AddTaskActivity extends AppCompatActivity
{
    private Button btnSaveTask;
    private Button btnCancelTask;
    private TextView tvImportance;
    private SeekBar skbrImportance;
    private TextInputEditText etShortTitle;
    private AutoCompleteTextView autoEtSubj;
    private TextInputEditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        autoEtSubj=findViewById(R.id.autoEtSubj);
        etShortTitle=findViewById(R.id.etShortTitle);
        btnCancelTask=findViewById(R.id.btnCancelTask);
        btnSaveTask=findViewById(R.id.btnSaveTask);
        tvImportance=findViewById(R.id.tvImportance);
        skbrImportance=findViewById(R.id.skbrImportance);
        etText=findViewById(R.id.etText);

        initAutoEtSubjects();

    }
    /**
     * استخراج اسماء المواضيع من جدول المواضيع وعرضه بالحقل من نوع
     * AutoCompleteTextView
     * طريقة التعامل معه شبيه بالسبنر
     */
    private void initAutoEtSubjects()
    {
        //مؤشر لقاعدة البيانات
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //مؤشر لواجهة استعمالات جدول المواضيع
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        // مصدر المعطيات : استخراج جميع المواضيع من الجدول
        List<MySubject> allSubjects = subjectQuery.getAllSubject();
        //جهيز الوسيط
        ArrayAdapter<MySubject> adapter = new ArrayAdapter<MySubject>(this, android.R.layout.simple_dropdown_item_1line);
        adapter.addAll(allSubjects);//اضافة جميع المعطيات للوسيط
        autoEtSubj.setAdapter(adapter);// ربط الحقل بالوسيط
        //معالجة حدث لعرض المواضيع عند الضغط على الحقل
        autoEtSubj.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                autoEtSubj.showDropDown();

            }
        });


    }
    private void checkAndSaveTask()
    {
        boolean isALLOK = true;//t يحوي نتيجة فحص الحقول ان كانت سلمي
        String subjText =etShortTitle.getText().toString();
        String autoSubj=autoEtSubj.getText().toString();
        int lmportance=skbrImportance.getProgress();
        String ImportanceT=tvImportance.getText().toString();
        String textTask=tvImportance.getText().toString();


        if(isALLOK)
        {



            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MySubjectQuery subjectQuery = db.getMySubjectQuery();
            if (subjectQuery.checkSubject(subjText)==null)
            { //بناء موضوع جديد واضافته
                MySubject subject = new MySubject();
                subject.title=subjText;
                subjectQuery.insertAll(subject);

            }
            // id استخراج الموضوع لاننا بحاجة لرقمه التسلسلي
            MySubject subject=subjectQuery.checkSubject(subjText);
            //بناء مهمة جديد وتحديد صفاتها
            MyTask task=new MyTask();
            task.importance=lmportance;
            task.text=textTask;
            task.shortTitle=subjText;
            task.subjId=subject.key_id; //تحديد رقم الموضوع للمهمة
            db.getMyTaskQuery().insertAll(task);//اضافة مهمة للجدول
            finish();



        }

    }







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
            Intent i = new Intent(AddTaskActivity.this, AddTaskActivity.class);
            startActivity(i);
        }
        return true;

    }










}