package com.wgu.scheduleapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wgu.scheduleapp.Database.Repository;
import com.wgu.scheduleapp.Entity.Assessment;
import com.wgu.scheduleapp.Entity.Course;
import com.wgu.scheduleapp.Entity.Term;
import com.wgu.scheduleapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repo = new Repository(getApplication());
        Assessment assessment = new Assessment(1,"Test 1",true,"Jan 1st","Jan 31st");
        repo.insertAssessment(assessment);
        Assessment assessment2 = new Assessment(2,"Test2",false,"Feb 1st","Feb 28th");
        repo.insertAssessment(assessment2);
        Course course1 = new Course(1,"Test Course 1", "Jan 1st", "Jan 31st");
        repo.insertCourse(course1);
        System.out.println("Course Added");
        Term term1 = new Term(1,"Test Term 1", "Jan 2nd", "Jan 32nd");
        repo.insertTerm(term1);
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