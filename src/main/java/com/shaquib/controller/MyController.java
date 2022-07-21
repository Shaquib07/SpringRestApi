package com.shaquib.controller;

import com.shaquib.Dto.CourseDto;
import com.shaquib.entity.Course;
import com.shaquib.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {



    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getCourseId(Long.parseLong(courseId));

    }

    @PostMapping("/courses")
    public  ResponseEntity<Course> postCourse(@RequestBody Course course){
        return  new ResponseEntity<>(courseService.addCourse(course),HttpStatus.CREATED);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<CourseDto> putCourse(@PathVariable String courseId, @RequestBody CourseDto course){
        return new ResponseEntity<>(courseService.updateCourse(Long.parseLong(courseId),course), HttpStatus.OK);

    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") long courseId){
        return courseService.removeCourse(courseId);

    }


}

