package com.wgu.scheduleapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.wgu.scheduleapp.DAO.AssessmentDAO;
import com.wgu.scheduleapp.DAO.CourseDAO;
import com.wgu.scheduleapp.DAO.TermDAO;
import com.wgu.scheduleapp.Entity.Assessment;
import com.wgu.scheduleapp.Entity.Course;
import com.wgu.scheduleapp.Entity.Term;

@Database(entities = {Assessment.class, Course.class, Term.class}, version = 4, exportSchema = false)
public abstract class ScheduleAppDatabaseBuilder extends RoomDatabase {
    public abstract AssessmentDAO assessmentDAO();
    public abstract CourseDAO courseDAO();
    public abstract TermDAO termDAO();

    private static volatile ScheduleAppDatabaseBuilder INSTANCE;

    static ScheduleAppDatabaseBuilder getDatabase(final Context context) {
        if(INSTANCE==null) {
            synchronized (ScheduleAppDatabaseBuilder.class) {
                if(INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ScheduleAppDatabaseBuilder.class, "ScheduleAppDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
