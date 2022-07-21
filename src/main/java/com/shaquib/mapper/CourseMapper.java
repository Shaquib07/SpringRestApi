package com.shaquib.mapper;

import com.shaquib.Dto.CourseDto;
import com.shaquib.entity.Course;

public interface CourseMapper {
    Course dtoToEntity(CourseDto courseDto);
    CourseDto entityToDto(Course course);

}
