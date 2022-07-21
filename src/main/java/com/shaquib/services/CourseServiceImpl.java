package com.shaquib.services;

import com.shaquib.Dao.CourseDao;
import com.shaquib.Dto.CourseDto;
import com.shaquib.entity.Course;
import com.shaquib.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> list;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourseId(long courseId) {
        return courseDao.findById(courseId).orElseThrow(() -> new RuntimeException("id not present"));
    }

    @Override
    public Course addCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public CourseDto updateCourse(long courseId, CourseDto courseDto) {
        Course entity = courseDao.findById(courseId).orElseThrow(() -> new RuntimeException("Id not present"));
        entity.setDescription(courseDto.getDescription());
        entity.setTitle(courseDto.getTitle());
        return courseMapper.entityToDto(courseDao.save(entity));
    }

    @Override
    public ResponseEntity<String> removeCourse(long id) {
        Optional<Course> course = courseDao.findById(id);
        if (course.isPresent()) {
            courseDao.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Course not exists for id :: " + id, HttpStatus.NOT_FOUND);
    }
}
