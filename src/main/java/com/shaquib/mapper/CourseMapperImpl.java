package com.shaquib.mapper;

import com.shaquib.Dto.CourseDto;
import com.shaquib.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperImpl implements CourseMapper{
    @Override
    public Course dtoToEntity(CourseDto courseDto) {
        if(courseDto == null)
            return null;

        return Course.builder().
                title(courseDto.getTitle()).
                description(courseDto.getDescription()).build();
    }

    @Override
    public CourseDto entityToDto(Course course) {
        if(course== null)
            return  null;

        CourseDto.CourseDtoBuilder builder= CourseDto.builder();
        builder.description(course.getTitle());
        builder.title(course.getTitle());
        return builder.build();
    }
}
