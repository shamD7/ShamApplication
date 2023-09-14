package sham.dawod.shamapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //456456456465
        setContentView(R.layout.activity_main);
        Log.d("SD","onCreate" );
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("SD","onRestart" );
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("SD","onResume" );
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SD","onStop" );
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
}