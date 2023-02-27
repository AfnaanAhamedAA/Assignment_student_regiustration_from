package com.student_registration.Service;

import com.student_registration.Entities.StudentInfo;
import com.student_registration.Entities.StudentMarks;
import com.student_registration.Exception.ResourceNotFoundException;
import com.student_registration.Payload.StudentMarksDto;
import com.student_registration.Repository.StudentInfoRepository;
import com.student_registration.Repository.StudentMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentMarksServiceImpl implements StudentMarksService{

    @Autowired
    private StudentInfoRepository stdInfoRepo;
    @Autowired
    private StudentMarksRepository stdMarksRepo;

    @Override
    public StudentMarksDto createMarksDetails(long std_id, StudentMarksDto stdMarksDto) {
        StudentMarks student_marks = mapToEntity(stdMarksDto);
        StudentInfo student_info = stdInfoRepo.findById(std_id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", std_id));
        student_marks.setStudentInfo(student_info);
        StudentMarks savedMarks = stdMarksRepo.save(student_marks);
        return mapToDto(savedMarks);
    }


    @Override
    public List<StudentMarksDto> getMarksDetails(long stdId) {
        List<StudentMarks> byStudentInfoId = stdMarksRepo.findByStudentInfoId(stdId);
        List<StudentMarksDto> collect = byStudentInfoId.stream().map(stdMarks -> mapToDto(stdMarks)).collect(Collectors.toList());
        return collect;
    }

    public StudentMarks mapToEntity(StudentMarksDto studentMarksDto) {
        StudentMarks stdMarks = new StudentMarks();
        stdMarks.setStd_session(studentMarksDto.getStd_session());
        stdMarks.setSemester(studentMarksDto.getSemester());
        stdMarks.setTotal_subject(studentMarksDto.getTotal_subject());
        stdMarks.setTotal_marks(studentMarksDto.getTotal_marks());
        return stdMarks;
    }
    public StudentMarksDto mapToDto(StudentMarks stdMarks){
        StudentMarksDto stdMarksDto =new StudentMarksDto();
        stdMarksDto.setId(stdMarks.getId());
        stdMarksDto.setStd_session(stdMarks.getStd_session());
        stdMarksDto.setSemester(stdMarks.getSemester());
        stdMarksDto.setTotal_subject(stdMarks.getTotal_subject());
        stdMarksDto.setTotal_marks(stdMarks.getTotal_marks());
        return stdMarksDto;
    }
}
