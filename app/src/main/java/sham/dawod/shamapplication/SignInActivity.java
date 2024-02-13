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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import sham.dawod.shamapplication.data.AppDatabase;
import sham.dawod.shamapplication.data.usersTable.MyUser;
import sham.dawod.shamapplication.data.usersTable.MyUserQuery;


public class SignInActivity extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSignIn;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sighin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

    }

    /**
     * دالة لمعالجة حدث الضغط على كائن بمواجهة المستعمل.
     * على سبيل المثال ر للكائن الذي سبب الحدث
     */

    public void onClickSIGNUP(View v) {
        Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(i);
        //to close current activity
        finish();
    }

    public void onClickSignIn (View v)
    {
        checkEmailPassw();

    }

        private void checkEmailPassw() {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
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
        if (isALLOK)
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();

            //بناء قاعدة بيانات وارجاع المؤشر عليها
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول
            MyUserQuery userQuery = db.getMyUserQuery();

            // ان لم يكن موجود استدعاء العملبة التي تنفذ الاستعلام الذي يفحص البريد و كلمة المرور ويعيد كائنا ان كان موجود
            MyUser myUse = userQuery.checkEmailPassw(email, password);
            if (myUse == null) //هل لا يوجد كائن حسب الايمل والباسورد
                Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_LONG).show();
            else
            {
                // ان كان هنالك حساب حساب الايميل والباسورد ننتقل الى الشاشة الرئيسية
                Intent i = new Intent(SignInActivity.this, MainActivity3.class);
                startActivity(i);
                //to close current activity
                finish();
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
            Intent i = new Intent(SignInActivity.this, AddTaskActivity.class);
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
                FirebaseAuth.getInstance().signOut();
                //معالجة حدث للموافقة
                Toast.makeText(SignInActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
                finish();



            }
        });
        //النض على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة حدث للموافقة
                Toast.makeText(SignInActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();//بناء شباك الحوار
        dialog.show();//عرض الشباك
    }

    private void checkEmailPassw_FB() {
        boolean isALLOK = true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email = etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password = etPassword.getText().toString();
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
        if (isALLOK)
        {
            //كائن لعملية التسجيل
            FirebaseAuth auth=FirebaseAuth.getInstance();
            //لدخول للحساب بمساعدة الايميل وكلمة المرور
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override//התגובה שמתקבל מהענן הכניסה בענן
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful()){//אם הפעולה הצליחה
                        Toast.makeText(SignInActivity.this, "Signing in", Toast.LENGTH_SHORT).show();
                        //מעבר למסך הראשי
                        Intent i = new Intent(SignInActivity.this,MainActivity3.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(SignInActivity.this, "Signing in Failed", Toast.LENGTH_SHORT).show();
                        etEmail.setError(task.getException().getMessage());//הצגת הודעת השגיה שהקבלה מהענן
                    }



                }
            });




        }

    }
}

