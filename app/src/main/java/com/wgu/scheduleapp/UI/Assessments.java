package com.wgu.scheduleapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wgu.scheduleapp.R;

public class Assessments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assesments);
    }

    public void openNewAssessment(View view) {
        Intent intent = new Intent(Assessments.this, NewAssessment.class);
        startActivity(intent);
    }
}