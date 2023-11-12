package sham.dawod.shamapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SighUpActivity extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etRepassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private Button btnSAVE;
    private Button btnCancel;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sighup);
        etEmail=(TextInputEditText) findViewById(R.id.etEmail);
        etPassword=(TextInputEditText)findViewById(R.id.etPassword);
        etRepassword=(TextInputEditText)findViewById(R.id.etRepassword);
        etName=(TextInputEditText)findViewById(R.id.etName);
        etPhone=(TextInputEditText)findViewById(R.id.etPhone);
        btnSAVE=(Button) findViewById(R.id.btnSAVE);
        btnCancel=(Button) findViewById(R.id.btnCancel);

    }
    private  void checkEmailPassw()
    {
        boolean isALLOK=true;// يحوي نتيجة فحص الحقول ان كانت سلمي
        //استخراج النص من حقل الايميل
        String email=etEmail.getText().toString();
        // استخراج نص كلمة المرور
        String password =etPassword.getText().toString();
        //فحص الايمل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if(email.length()<6 || email.contains("@")==false);
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etEmail.setError("Wrong Email");
        }
        if(password.length()<8 || password.contains("")==true);
        // تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
        {
            isALLOK = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل لمة المرور
            etEmail.setError("Wrong Password");
        }
        if(isALLOK);
        {
            Toast.makeText(this, "ALL OK ", Toast.LENGTH_SHORT).show();
        }





    }

}