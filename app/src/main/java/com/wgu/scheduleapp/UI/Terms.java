package com.wgu.scheduleapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wgu.scheduleapp.R;

public class Terms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
    }

    public void openNewTerm(View view) {
        Intent intent = new Intent(Terms.this, NewTerm.class);
        startActivity(intent);

    }
}