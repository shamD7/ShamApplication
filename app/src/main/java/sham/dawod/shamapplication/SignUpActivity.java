package sham.dawod.shamapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.usersTable.MyUser;
import sham.dawod.shamapplication.data.usersTable.MyUserQuery;

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etRepassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private Button btnSAVE;
    private Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sighup);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);
        etRepassword = (TextInputEditText) findViewById(R.id.etRepassword);
        etName = (TextInputEditText) findViewById(R.id.etName);
        etPhone = (TextInputEditText) findViewById(R.id.etPhone);
        btnSAVE = (Button) findViewById(R.id.btnSAVE);
        btnCancel = (Button) findViewById(R.id.btnCancel);

    }
    public void onClickSave(View v)
    {
        checkEmailPassw();

    }
    private void onClickCancel(View v)
    {
        Intent i = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(i);
        //to close current activity
        finish();
    }



    private void checkEmailPassw() {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
        // استخراج نص كلمة المرور
        String repassword = etRepassword.getText().toString();
        // استخراج نص الاسم

        String name = etName.getText().toString();
        // استخراج نص رقم الهاتف

        String phone = etPhone.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (email.length() < 6 || email.contains("@") == false)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if (password.length() < 8 || password.contains(" ") == true)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etPassword.setError("Wrong Password");
        }
        if (repassword.equals(password)==false)
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etRepassword.setError("Wrong re-Password");
        }
        if (phone.length() < 10 )
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل قم الهاتف
            etPhone.setError("Wrong Phone Number");
        }
        if (name.length() < 1 )
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل الاسم
            etName.setError("Wrong Name");
        }


        if (isALLOK) ;
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MyUserQuery userQuery = db.getMyUserQuery();
            //حص هل البريد الكتروني موجود من قبل اي تم التسجيل من قبل


            if (userQuery.checkEmail(email) != null)
            {
                etEmail.setError("found email");


            } else //ان لم يكن البريد موجود نثقوم ببناء كائن للمستعمل وادخاله في جدول المستعملين MyUser
            {

                MyUser myUser = new MyUser(); // بناء كائن
                //تحديد قيم الصفات بالقيم التي استخرجناها
                myUser.fullName = name;
                myUser.phone = phone;
                myUser.passw = password;
                myUser.email = email;
                //اضافة الكائن الجديد للجدول
                userQuery.insert((myUser));

            }


        }
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
            showYesNoDialig();

        }
        if (item.getItemId()==R.id.ItemAddTask)
        {
            Intent i = new Intent(SignUpActivity.this, AddTaskActivity.class);
            startActivity(i);
        }
        return true;

    }
    public void showYesNoDialig()
    {
        //جهيز بناء شباك حوار بارمتر مؤشر للنشاط الحالي
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحدي فحوى شباك الحوار
        //النض على الزر ومعالج الحدث
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //معالجة حدث للموافقة
                Toast.makeText(SignUpActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
        //النض على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(SignUpActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار
        dialog.show();//عرض الشباك
    }

}


