package com.student_registration.Service;

import com.student_registration.Payload.StudentInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentInfoService {

    public List<StudentInfoDto> createDetails(List<StudentInfoDto> stdInfoDto);

    public List<StudentInfoDto> getAllDetails();

    public StudentInfoDto getStudentInfoById(long stdId);
}