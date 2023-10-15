package sham.dawod.shamapplication.data;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import sham.dawod.shamapplication.R;
import sham.dawod.shamapplication.data.MySubjectTable.MySubject;

public class MainActivity extends AppCompatActivity {
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

}