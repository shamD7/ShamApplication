package sham.dawod.shamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;
import sham.dawod.shamapplication.data.MySubjectTable.MySubjectQuery;
import sham.dawod.shamapplication.data.usersTable.MyUserQuery;

public class AddTaskActivity extends AppCompatActivity
{
    private Button btnSaveTask;
    private Button btnCancelTask;
    private TextView tvlmportance;
    private SeekBar skbrlmportance;
    private TextInputEditText etShortTitle;
    private AutoCompleteTextView autoEtSubj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        autoEtSubj=findViewById(R.id.autoEtSubj);
        initAutoEtSublects();

    }
    /**
     * استخراج اسماء المواضيع من جدول المواضيع وعرضه بالحقل من نوع
     * AutoCompleteTextView
     * طريقة التعامل معه شبيه بالسبنر
     */
    private void initAutoEtSublects

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
            public void onClick(View view) {

            }
        });




    }
    private void checkAndSaveTask()
    {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي

        s

        if(isALLOK){

            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MySubjectQuery subjectQuery = db.getMySubjectQuery();
            if (subjectQuery.checkSubject(subjText)==null)
            {



            }



        }

    }


}