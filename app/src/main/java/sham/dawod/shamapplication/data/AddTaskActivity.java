package sham.dawod.shamapplication.data;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import sham.dawod.shamapplication.R;

public class AddTaskActivity1 extends AppCompatActivity {
    private Button btnSaveTask;
    private Button btnCancelTask;
    private TextView tvImportance;
    private SeekBar skbrImportance;
    private TextInputEditText etShortTitle;
    private TextInputEditText etText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancelTask = findViewById(R.id.btnCancelTask);
        tvImportance = findViewById(R.id.tvImportance);
        skbrImportance = findViewById(R.id.skbrImportance);
        etShortTitle = findViewById(R.id.etShortTitle);
        etText = findViewById(R.id.etText);

    }

    public void checkTextAndShortTitle()
    {
        boolean isAllOk = true;
        String text = etText.getText().toString();
        String shortTitle = etShortTitle.getText().toString();
        if (text.length() < 0) {
            isAllOk = false;
            etText.setError("Wrong text");
        }
        if (shortTitle.length() < 0) {
            isAllOk = false;
            etShortTitle.setError("Wrong shortTitle");
        }
        if (isAllOk) {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }
    }
}
