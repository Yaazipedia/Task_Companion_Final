package com.example.taskcompanion;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageButton create,pending,explore,add;
    Button start;
    EditText task,time;


    public  void create(View view){

        setContentView(R.layout.create_task);
        task = findViewById(R.id.task);
        time = findViewById(R.id.timer);

        Log.i("Tag","user creates a task");

    }

    public void startcountdown(View view) throws ParseException {

       String deadline = time.getText().toString();

        String taskString = task.getText().toString();
        Toast.makeText(this,"You have added "+taskString+" with deadline as "+deadline, Toast.LENGTH_LONG).show();

        new CountDownTimer((Integer.parseInt(deadline)*1000)+100 , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(Integer.toString((int)millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        create = findViewById(R.id.create);
        pending = findViewById(R.id.pending);
        explore = findViewById(R.id.explore);
        add = findViewById(R.id.addnew);
        start = findViewById(R.id.start);
    }
}
