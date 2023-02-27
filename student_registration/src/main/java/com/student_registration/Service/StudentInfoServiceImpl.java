package com.student_registration.Service;

import com.student_registration.Entities.StudentInfo;
import com.student_registration.Exception.ResourceNotFoundException;
import com.student_registration.Payload.StudentInfoDto;
import com.student_registration.Repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepo;


    @Override
    public List<StudentInfoDto> createDetails(List<StudentInfoDto> stdInfoDto) {
        List<StudentInfo> stdcollect = stdInfoDto.stream().map(stdDto -> mapToEntity(stdDto)).collect(Collectors.toList());
        List<StudentInfo> student_infos = studentInfoRepo.saveAll(stdcollect);
        List<StudentInfoDto> collectDto = student_infos.stream().map(std_infos -> mapToDto(std_infos)).collect(Collectors.toList());
        return collectDto;
    }

    @Override
    public List<StudentInfoDto> getAllDetails() {
        List<StudentInfo> detailsEntity = studentInfoRepo.findAll();
     return detailsEntity.stream().map(stdInfo->mapToDto(stdInfo)).collect(Collectors.toList());
    }


    @Override
    public StudentInfoDto getStudentInfoById(long stdId) {
        studentInfoRepo.findById(stdId).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", stdId))
        return mapToDto(studentInfo);
    }

    public StudentInfo mapToEntity(StudentInfoDto stdInfoDto) {
        StudentInfo stdInfo = new StudentInfo();
        stdInfo.setStd_name(stdInfoDto.getStd_name());
        stdInfo.setStd_address(stdInfoDto.getStd_address());
        stdInfo.setStd_email(stdInfoDto.getStd_email());
        stdInfo.setStd_phoneno(stdInfoDto.getStd_phoneno());
        stdInfo.setStd_section(stdInfoDto.getStd_section());
        stdInfo.setStd_grade(stdInfoDto.getStd_grade());
        return stdInfo;
    }
    public StudentInfoDto mapToDto(StudentInfo stdInfo){
        StudentInfoDto stdInfoDto = new StudentInfoDto();
        stdInfoDto.setId(stdInfo.getId());
        stdInfoDto.setStd_name(stdInfo.getStd_name());
        stdInfoDto.setStd_address(stdInfo.getStd_address());
        stdInfoDto.setStd_email(stdInfo.getStd_email());
        stdInfoDto.setStd_phoneno(stdInfo.getStd_phoneno());
        stdInfoDto.setStd_section(stdInfo.getStd_section());
        stdInfoDto.setStd_grade(stdInfo.getStd_grade());
        return stdInfoDto;
    }
}
