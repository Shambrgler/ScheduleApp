package com.wgu.scheduleapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wgu.scheduleapp.Entity.Assessment;
import com.wgu.scheduleapp.Entity.Course;
import com.wgu.scheduleapp.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    class CourseViewHolder extends RecyclerView.ViewHolder{
        private final TextView courseItemView;
        private CourseViewHolder(View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.courseListItem);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Course current = mCourses.get(position);
                    Intent intent = new Intent(context, EditCourse.class);
                    intent.putExtra("id", current.getCourseID());
                    intent.putExtra("title", current.getCourseTitle());
                    intent.putExtra("startDate", current.getCourseStartDate());
                    intent.putExtra("endDate", current.getCourseEndDate());
                    //TODO: Add other attributes to send to next screen
                    context.startActivity(intent);


                }
            });
        }
    }

    private List<Course> mCourses;
    private final Context context;
    private final LayoutInflater mInflater;
    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses != null) {
            Course current = mCourses.get(position);
            String title = current.getCourseTitle();
            holder.courseItemView.setText(title);
        } else {
            holder.courseItemView.setText("No Course Title");
        }

    }

    public void setCourses(List<Course> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }

    public void setAssessments(List<Assessment> assessments) {

    }

    @Override
    public int getItemCount() {
        if(mCourses != null) {
            return mCourses.size();
        }
        else return 0;
    }}
