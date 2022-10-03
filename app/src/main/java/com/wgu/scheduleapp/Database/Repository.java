package com.wgu.scheduleapp.Database;

import android.app.Application;

import com.wgu.scheduleapp.DAO.AssessmentDAO;
import com.wgu.scheduleapp.DAO.CourseDAO;
import com.wgu.scheduleapp.DAO.TermDAO;
import com.wgu.scheduleapp.Entity.Assessment;
import com.wgu.scheduleapp.Entity.Course;
import com.wgu.scheduleapp.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private AssessmentDAO mAssessmentDAO;
    private CourseDAO mCourseDAO;
    private TermDAO mTermDAO;
    private List<Assessment> mAllAssessments;
    private List<Course> mAllCourses;
    private List<Term> mAllTerms;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        ScheduleAppDatabaseBuilder db = ScheduleAppDatabaseBuilder.getDatabase(application);
        mAssessmentDAO = db.assessmentDAO();
        mCourseDAO = db.courseDAO();
        mTermDAO = db.termDAO();
    }

    public void insertAssessment(Assessment assessment) {
        databaseExecutor.execute(()->{
            mAssessmentDAO.insert(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAssessment(Assessment assessment) {
        databaseExecutor.execute(()->{
            mAssessmentDAO.update(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAssessment(Assessment assessment) {
        databaseExecutor.execute(()-> {
            mAssessmentDAO.delete(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Assessment> getAllAssessments() {
        databaseExecutor.execute(()-> {
            mAllAssessments = mAssessmentDAO.getAllAssessments();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return mAllAssessments;
    }

    public void insertCourse(Course course) {
        databaseExecutor.execute(()-> {
            mCourseDAO.insert(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCourse(Course course) {
        databaseExecutor.execute(()-> {
            mCourseDAO.update(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCourse(Course course) {
        databaseExecutor.execute(()-> {
            mCourseDAO.delete(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        databaseExecutor.execute(()->{
            mAllCourses = mCourseDAO.getAllCourses();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return mAllCourses;
    }

    public void insertTerm(Term term) {
        databaseExecutor.execute(()->{
            mTermDAO.insert(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTerm(Term term) {
        databaseExecutor.execute(()->{
            mTermDAO.update(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTerm(Term term) {
        databaseExecutor.execute(()->{
            mTermDAO.delete(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Term> getAllTerms() {
        databaseExecutor.execute(()->{
            mAllTerms = mTermDAO.getAllTerms();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return mAllTerms;
    }
}
