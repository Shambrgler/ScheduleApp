package com.wgu.scheduleapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wgu.scheduleapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTerms(View view) {
        Intent intent = new Intent(MainActivity.this, Terms.class);
        startActivity(intent);
    }

    public void openCourses(View view) {
        Intent intent = new Intent(MainActivity.this, Courses.class);
        startActivity(intent);
    }

    public void openAssessments(View view) {
        Intent intent = new Intent(MainActivity.this, Assessments.class);
        startActivity(intent);
    }
}