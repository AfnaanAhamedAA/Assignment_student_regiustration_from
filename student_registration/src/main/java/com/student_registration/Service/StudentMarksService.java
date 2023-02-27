package com.student_registration.Service;

import com.student_registration.Payload.StudentMarksDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentMarksService {

    public StudentMarksDto createMarksDetails(long std_id, StudentMarksDto stdMarksDto);
    public List<StudentMarksDto> getMarksDetails(long stdId);
}
