package com.shaquib.services;

import com.shaquib.Dto.CourseDto;
import com.shaquib.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
     List<Course> getCourses();
     Course getCourseId(long courseid);
     Course addCourse(Course course);
      CourseDto updateCourse(long courseId, CourseDto course);
    ResponseEntity<String> removeCourse(long id);


}
