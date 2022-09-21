package com.wgu.scheduleapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wgu.scheduleapp.R;

public class EditAssessment extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button startDateButton;
    private Button endDateButton;
    private TextView startDate;
    private TextView endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assessment);
        startDateButton = findViewById(R.id.editAssessmentStart);
        endDateButton = findViewById(R.id.editAssessmentEnd);
        startDate = findViewById(R.id.textEditAssessmentStart);
        endDate = findViewById(R.id.textEditAssessmentEnd);

    }

    private void initStartDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            //TODO create method to save date, this method only changes the text
            String date = makeDateString(day, month, year);
            startDateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    private void initEndDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            //TODO create method to save date, this method only changes the text
            String date = makeDateString(day, month, year);
            endDateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        if (month == 0) { return "Jan "  + day + ", " + year; }
        if (month == 1) { return "Feb "  + day + ", " + year; }
        if (month == 2) { return "Mar "  + day + ", " + year; }
        if (month == 3) { return "Apr "  + day + ", " + year; }
        if (month == 4) { return "May "  + day + ", " + year; }
        if (month == 5) { return "Jun "  + day + ", " + year; }
        if (month == 6) { return "Jul "  + day + ", " + year; }
        if (month == 7) { return "Aug "  + day + ", " + year; }
        if (month == 8) { return "Sep "  + day + ", " + year; }
        if (month == 9) { return "Oct "  + day + ", " + year; }
        if (month == 10) { return "Nov "  + day + ", " + year; }
        if (month == 11) { return "Dec "  + day + ", " + year; }

        return "Error";
    }

    public void openStartDatePicker(View view) {
        initStartDatePicker();
        datePickerDialog.show();
    }

    public void openEndDatePicker(View view) {
        initEndDatePicker();
        datePickerDialog.show();
    }

    public void saveDate(View view) {
        //TODO save dates to database; currently only saves text
        startDate.setText(startDateButton.getText());
        endDate.setText(endDateButton.getText());
    }
}