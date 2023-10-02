package sham.dawod.shamapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SighUpActivity extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputEditText etRepassword;
    private TextInputEditText etName;
    private TextInputEditText etPhone;
    private Button btnSAVE;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigh_up);
        etEmail=(TextInputEditText) findViewById(R.id.etEmail);
        etPassword=(TextInputEditText)findViewById(R.id.etPassword);
        etRepassword=(TextInputEditText)findViewById(R.id.etRepassword);
        etName=(TextInputEditText)findViewById(R.id.etName);
        etPhone=(TextInputEditText)findViewById(R.id.etPhone);
        btnSAVE=(Button) findViewById(R.id.btnSAVE);

    }
}