package sham.dawod.shamapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;


public class SighInActivity extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSighIn;
    private Button btnSighUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigh_up);
        setContentView(R.layout.activity_sigh_in);
        etEmail=(TextInputEditText) findViewById(R.id.etEmail);
        etPassword=(TextInputEditText)findViewById(R.id.etPassword);
        btnSighIn=(Button) findViewById(R.id.btnSignIn);
        btnSighUp=(Button) findViewById(R.id.btnSignUp);

    }
}