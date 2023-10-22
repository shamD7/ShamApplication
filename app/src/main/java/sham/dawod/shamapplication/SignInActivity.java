package sham.dawod.shamapplication;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class SignInActivity extends AppCompatActivity
{
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSighIn;
    private Button btnSighUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sighup);
        setContentView(R.layout.sighin);
        etEmail= findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

    }
}